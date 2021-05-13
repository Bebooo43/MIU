package cs544.team7.project;

import cs544.team7.project.model.*;
import cs544.team7.project.repository.AppointmentRepository;
import cs544.team7.project.repository.PersonRepository;
import cs544.team7.project.repository.SessionRepository;
import cs544.team7.project.service.AppointmentService;
import cs544.team7.project.service.IAppointmentService;
import cs544.team7.project.service.ISessionService;
import cs544.team7.project.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;

@Component
public class StartUpRunner implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private AppointmentService appointmentService;
    
    @Transactional
    public void run(String...args) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Role providerRole = new Role(RoleType.PROVIDER);
        Role clientRole = new Role(RoleType.CLIENT);
        Role adminRole = new Role(RoleType.ADMIN);
        Person client = new Person(
                "John", "Smith", "client@gmail.com",
                "client",
                encoder.encode("1234"),
                Arrays.asList(clientRole));
        Person client2 = new Person(
                "John", "Smith", "jmsvsmorone@gmail.com",
                "jsmith",
                encoder.encode("1234"),
                Arrays.asList(clientRole));
        Person admin = new Person(
                "Mike", "Doe", "mdoe@gmail.com", "admin",
                encoder.encode("1234"),
                Arrays.asList(adminRole, providerRole));
        Person provider = new Person(
                "Steve", "Jobbs", "pro@gmail.com", "provider",
                encoder.encode("1234"),
                Arrays.asList(providerRole));

        Session session = new Session(
                LocalDate.of(2021, Month.MAY, 13),
                LocalTime.now(),
                120,
                "Dalby Hall",
                provider
        );

        Appointment appointment = new Appointment(client, session);
       // appointment.setStatus(AppointmentStatus.APPROVED);
        Appointment appointment2 = new Appointment(client2, session);
        personRepository.save(client);
        personRepository.save(client2);
        personRepository.save(admin);
        personRepository.save(provider);
        sessionRepository.save(session);
        appointmentRepository.save(appointment);
        //appointmentRepository.save(appointment);
        appointmentService.makeReservation(client2,session);
    }
}
