package cs544.team7.project.controller;

import cs544.team7.project.model.Appointment;
import cs544.team7.project.model.Person;
import cs544.team7.project.model.Session;
import cs544.team7.project.repository.PersonRepository;
import cs544.team7.project.service.AppointmentService;
import cs544.team7.project.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("provider")
public class ProviderController {
    @Autowired
    private SessionService sessionService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("sessions")
    public Session createSession(@RequestBody Session session) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Person person = personRepository.getPersonByUsername(user.getUsername());
        session.setProvider(person);
        return sessionService.createSession(session);
    }

    @GetMapping("sessions")
    public List<Session> getSessions() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Person person = personRepository.getPersonByUsername(user.getUsername());
        return sessionService.getAllSessionsByProvider(person);
    }

    @GetMapping("sessions/available")
    public List<Session> getAvailableSessions() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Person person = personRepository.getPersonByUsername(user.getUsername());
        return sessionService.getAllAvailableSessionsByProvider(person);
    }

    @GetMapping("sessions/{id}")
    public Session getSessionById(@PathVariable(name = "id") int id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Person person = personRepository.getPersonByUsername(user.getUsername());
        Session s = sessionService.getSessionById(id);
        if(!s.getProvider().equals(person))
            return null;
        return s;
    }

    @PutMapping("appointments/{appointmentId}")
    public boolean approveAppointment(@PathVariable("appointmentId") int id )
    {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Person person = personRepository.getPersonByUsername(user.getUsername());
        Appointment appointment = appointmentService.getAppintmentById(id);
        if(!appointment.getSession().getProvider().equals(person))
            return false;
        return appointmentService.approveAppointment(person, appointment);
    }
}
