package cs544.team7.project.service;

import cs544.team7.project.exception.OldSessionException;
import cs544.team7.project.exception.SessionNotFoundException;
import cs544.team7.project.model.*;
import cs544.team7.project.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static cs544.team7.project.model.AppointmentStatus.APPROVED;

@Service
public class SessionService implements ISessionService {
    private SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }


    public Session createSession(Session session) {
        sessionRepository.findById(session.getId()).ifPresent(s -> {
            throw new RuntimeException("Already exists!");
        });
        if(session.getDate().isEqual(LocalDate.now()) || session.getDate().isBefore(LocalDate.now()))
            throw new RuntimeException("Late date!");
        if(session.getProvider() == null || !session.getProvider().getRoles().contains(new Role(RoleType.PROVIDER)))
            throw new RuntimeException("Do not have a provider!");
        return sessionRepository.save(session);
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public List<Session> getAllSessionsByProvider(Person provider) {
        return   getAllSessions()
                .stream()
                .filter(session -> session.getProvider().equals(provider))
                .collect(Collectors.toList());
    }

    public List<Session> getAllAvailableSessionsByProvider(Person provider) {
        return  getAllAvailableSessions().stream()
                .filter(session -> session.getProvider().equals(provider))
                .collect(Collectors.toList());
    }

    public List<Session> getAllAvailableSessions() {
        return
        sessionRepository.findAll()
                .stream()
                .filter(session -> session.getDate().isAfter(LocalDate.now()) || (session.getDate().isEqual(LocalDate.now()) && session.getStartTime().isAfter(LocalTime.now())))
                .filter(session -> {
                    for(Appointment a : session.getAppointments())
                            if (a.getStatus() == APPROVED) return false;
                    return true;
                })
                .collect(Collectors.toList());
    }

    public Session getSessionById(int id) {
        return sessionRepository.findById(id).orElseThrow(SessionNotFoundException::new);
    }



    public Session updateSession(Session session) {
        Session s2 = sessionRepository.findById(session.getId()).orElseThrow(RuntimeException::new);
        if(s2.getDate().isBefore(LocalDate.now()))
            throw new OldSessionException();
        if (s2.getId() == session.getId()) {
            if(session.getProvider() == null) session.setProvider(s2.getProvider());
            if(session.getDate() == null) session.setDate(s2.getDate());
            if(session.getStartTime() == null) session.setStartTime(s2.getStartTime());
            if(session.getDuration() == 0) session.setDuration(s2.getDuration());
            if(session.getLocation() == null) session.setLocation(s2.getLocation());
            sessionRepository.save(session);
        } else {
            throw new SessionNotFoundException();
        }
        return session;
    }

    public Session deleteSession(Session session) {
        Session s2 = sessionRepository.findById(session.getId()).orElseThrow(RuntimeException::new);
        if (s2.getId() == session.getId()) {
            sessionRepository.delete(session);
        }
        return session;
    }
}
