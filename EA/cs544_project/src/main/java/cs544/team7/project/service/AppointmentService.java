package cs544.team7.project.service;

import cs544.team7.project.exception.AppointmentNotFoundException;
import cs544.team7.project.exception.OldSessionException;
import cs544.team7.project.model.*;
import cs544.team7.project.repository.AppointmentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static cs544.team7.project.model.AppointmentStatus.*;
import static cs544.team7.project.model.RoleType.*;

@Service
@Log4j2
public class AppointmentService implements IAppointmentService {
    private Person admin = new Person("", "", "", "", "",
            Arrays.asList(new Role(ADMIN)));
    private AppointmentRepository  appointmentRepository;
    @Autowired
    private IEmailService emailService;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
                              IEmailService emailService) {
        this.appointmentRepository = appointmentRepository;
        this.emailService = emailService;
    }

    @Override
    public Appointment makeReservation(Person p, Session s) {
        if(p == null || s == null) throw new IllegalArgumentException("Argument is null");
        boolean sessionApproved =  s.getAppointments().stream().filter(
                appointment -> appointment.getStatus() == APPROVED
        ).count() >= 1L;
        boolean isClient =  p.getRoles()
                             .stream()
                             .filter(role -> role.getType() == CLIENT)
                             .count() >= 1L;
        if(sessionApproved) throw new IllegalStateException("Sesssion has already been assigned!");
        if(LocalDate.now().isAfter(s.getDate()) ||
                (LocalDate.now().isEqual(s.getDate()) && LocalTime.now().isAfter(s.getStartTime())))
            throw new OldSessionException();
        if(!isClient) throw new RuntimeException("Person is not client");
        emailService.sendMessage(p, "You have successfully created Appointment!");
        emailService.sendMessage(s.getProvider(), "Client has successfully created Appointment!");
        Appointment appointment = new Appointment(p, s);
        appointmentRepository.save(appointment);
        return appointment;
    }

    @Override
    public boolean cancelAppointment(Person p, Appointment a) {
        if(a == null || a.getClient() == null || a.getSession()==null)
            return false;

        AppointmentStatus prevStatus = PENDING;

        // Checking if session start time is not in the past
        if(LocalDate.now().isAfter(a.getSession().getDate()) ||
                (LocalDate.now().isEqual(a.getSession().getDate()) &&
                        LocalTime.now().isAfter(a.getSession().getStartTime()))) {
            return false;
        }

        Collection<Role> roles = p.getRoles();


        if(roles.contains(new Role(RoleType.ADMIN)) || roles.contains(new Role(PROVIDER))) {
            //RoleType is ADMIN & session start time is not past
            prevStatus = a.getStatus();
            a.getSession().removeAppointment(a);
            if(a.getStatus() != CANCELED) {
                a.setStatus(AppointmentStatus.CANCELED);
                updateAppointment(p, a);
            }
        }//these two if can become one just checking if is not admin and verifying the 48h rule
        if(roles.contains(new Role(RoleType.CLIENT))) {
            // RoleType is not ADMIN --> Checking if session start time is after more than 48 hrs
            if(LocalTime.now().plusHours(48).isAfter(a.getSession().getStartTime())){
                return false;
            }
            prevStatus = a.getStatus();
            a.getSession().removeAppointment(a);
            if(a.getStatus() != CANCELED) {
                a.setStatus(AppointmentStatus.CANCELED);
                updateAppointment(p, a);
            }
        }

        if(prevStatus == APPROVED) {
            List<Appointment> appointments = getAllPendingAppointmentsForSession(p, a.getSession());
            if(!appointments.isEmpty() && appointments.get(0) != null) {
                approveAppointment(admin, appointments.get(0));
            }
        }
        emailService.sendMessage(a.getClient(), a.getClient().getFname()+" your appointment was canceled for the TM session with "+a.getSession().getProvider().getFname()+" on "+a.getSession().getDate()+" at "+a.getSession().getStartTime());
        emailService.sendMessage(a.getSession().getProvider(), "Appointment canceled! Client: "+a.getClient().getFname()+", TM Session: "+a.getSession().getDate()+" at "+a.getSession().getStartTime());
        return true;
    }

    public boolean cancelAppointment2(Person p, Appointment a) {
        if(a == null || a.getClient() == null || a.getSession()==null) return false;
        AppointmentStatus prevStatus = PENDING;

        // Checking if session start time is not in the past
        if(LocalDate.now().isAfter(a.getSession().getDate()) || (LocalDate.now().isEqual(a.getSession().getDate())
                && LocalTime.now().isAfter(a.getSession().getStartTime())))
            return false;

        Collection<Role> roles = p.getRoles();
        if(!roles.contains(new Role(ADMIN)) && !roles.contains(new Role(ADMIN))) {
            // RoleType is not ADMIN OR Provider --> Checking if session start time is after more than 48 hrs
            if(LocalTime.now().plusHours(48).isAfter(a.getSession().getStartTime()))
                return false;
        }

        prevStatus = a.getStatus();
        a.getSession().removeAppointment(a);
        if(a.getStatus() != CANCELED) {
            a.setStatus(AppointmentStatus.CANCELED);
            updateAppointment(p, a);
        }

        if(prevStatus == APPROVED) {
            List<Appointment> appointments = getAllPendingAppointmentsForSession(p, a.getSession());
            if(!appointments.isEmpty() && appointments.get(0) != null) {
                approveAppointment(admin, appointments.get(0));
            }
        }
        emailService.sendMessage(a.getClient(), a.getClient().getFname()+" your appointment was canceled for the TM session with "+a.getSession().getProvider().getFname()+" on "+a.getSession().getDate()+" at "+a.getSession().getStartTime());
        emailService.sendMessage(a.getSession().getProvider(), "Appointment canceled! Client: "+a.getClient().getFname()+", TM Session: "+a.getSession().getDate()+" at "+a.getSession().getStartTime());
        return true;
    }


    @Override
    public List<Appointment> getAllPendingAppointmentsForSession(Person p, Session s) {
        if(s == null) throw new IllegalArgumentException("Argument is null");
        return s.getAppointments().stream().filter(
                appointment -> appointment.getStatus() == PENDING
        ).sorted(
                Comparator.comparing(Appointment::getRequestTime)
        ).collect(Collectors.toList());
    }

    @Override
    public Appointment getAppintmentById(int id) {
        return appointmentRepository.findById(id).orElseThrow(AppointmentNotFoundException::new);
    }

    @Override
    public List<Appointment> getApprovedAppointments() {
        return appointmentRepository.findAll().stream()
                .filter(a -> a.getStatus() == APPROVED)
                .collect(Collectors.toList());
    }

    @Override
    public List<Appointment> getCanceledAppointments() {
        return appointmentRepository.findAll().stream()
                .filter(a -> a.getStatus() == CANCELED)
                .collect(Collectors.toList());
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Appointment::getRequestTime))
                .collect(Collectors.toList());
    }

    @Override
    public boolean approveAppointment(Person p, Appointment a) {
        if(a == null || a.getClient() == null || a.getSession()==null)
            return false;

        Session s = a.getSession();
        Collection<Appointment> appointments = s.getAppointments();

        // Check session if it already has an APPROVED appointment
        for(Appointment apt : appointments) {
            if(apt.getStatus().equals(AppointmentStatus.APPROVED))
                return false;
        }

        Collection<Role> roles = p.getRoles();
        // Only PROVIDER or ADMIN can approve an appointment
        if(roles.contains(new Role(PROVIDER)) || roles.contains(new Role(ADMIN))) {
            a.setStatus(AppointmentStatus.APPROVED);
            updateAppointment(p, a);
            emailService.sendMessage(a.getClient(), "Your TM session appointment was approved!");
            return true;
        }

        return false;
    }

    @Override
    public void deleteAppointment(Person p, Appointment a) {
        a.getClient().removeAppointment(a);
        a.getSession().removeAppointment(a);
        appointmentRepository.delete(a);
        emailService.sendMessage(a.getClient(), "Your appointment deleted!");
        emailService.sendMessage(a.getSession().getProvider(), "Appointment deleted!");
    }

    @Override
    public void updateAppointment(Person p,Appointment a) {
        appointmentRepository.save(a);
        emailService.sendMessage(a.getClient(), "Your appointment updated!");
        emailService.sendMessage(a.getSession().getProvider(), "Appointment updated!");
    }
}
