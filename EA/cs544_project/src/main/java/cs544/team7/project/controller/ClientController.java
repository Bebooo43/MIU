package cs544.team7.project.controller;

import cs544.team7.project.model.Appointment;
import cs544.team7.project.model.Person;
import cs544.team7.project.model.PostForAppointment;
import cs544.team7.project.model.Session;
import cs544.team7.project.repository.PersonRepository;
import cs544.team7.project.service.AppointmentService;
import cs544.team7.project.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private SessionService sessionService;

    @GetMapping("appointments")
    public List<Appointment> getAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping("appointments")
    public Appointment createAppointment(@RequestBody PostForAppointment data) throws MessagingException, IllegalAccessException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getUsername());
        Person person = personRepository.getPersonByUsername(user.getUsername());
        System.out.println(person);
        Session session = sessionService.getSessionById(data.getSession_id());
        return appointmentService.makeReservation(person, session);
    }

    @DeleteMapping("appointments/{appointmentId}")
    public boolean cancelAppointment(@PathVariable("appointmentId") int id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Person person = personRepository.getPersonByUsername(user.getUsername());
        Appointment appointment = appointmentService.getAppintmentById(id);
        return appointmentService.cancelAppointment(person, appointment);
    }

}
