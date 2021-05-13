package cs544.team7.project.service;

import cs544.team7.project.model.Appointment;
import cs544.team7.project.model.Person;
import cs544.team7.project.model.Role;
import cs544.team7.project.model.Session;
import cs544.team7.project.repository.AppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static cs544.team7.project.model.AppointmentStatus.*;
import static cs544.team7.project.model.RoleType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {

    @Mock
    private AppointmentRepository repo;
    @Mock
    private IEmailService emailService;
    private AppointmentService underTest = null;
    private Person person = null;
    private Session session = null;
    private Appointment appointment = null;
    private Role clientRole = new Role(CLIENT);
    private Role providerRole = new Role(PROVIDER);


    @BeforeEach
    void setUp() {
        underTest = new AppointmentService(repo, emailService);
        person = new Person("John", "Smith", "jsmith@gmail.com", "jsmith", "1234", new LinkedList<>(Arrays.asList(clientRole, providerRole)));
        session = new Session(LocalDate.now().plusDays(4), LocalTime.now(), 120, "Darby Hall", person);
        appointment = new Appointment(person, session);
    }

    @Test
    void canMakeReservationTest() throws IllegalAccessException, MessagingException {
        // when
        Appointment a = underTest.makeReservation(person, session);

        // then
        verify(repo).save(a);
        verify(emailService).sendMessage(any(Person.class), anyString());
        assertThat(a.getClient()).isEqualTo(person);
        assertThat(a.getSession()).isEqualTo(session);
    }

    @Test
    void NotClientMakeReservationTest() {
        // Given
        person.removeRole(clientRole);
        // then
        assertThatThrownBy(() ->underTest.makeReservation(person, session));
    }

    @Test
    void NullSessionMakeReservationTest() {
        // then
        assertThatThrownBy(() ->underTest.makeReservation(person, null));
    }

    @Test
    void SessionAlreadyAssignedMakeReservationTest() {
        appointment.setStatus(APPROVED);
        // then
        assertThatThrownBy(() ->underTest.makeReservation(person, session));
    }

    @Test
    void SessionExpiredMakeReservationTest() {
        session.setDate(LocalDate.now().minusDays(1));
        // then
        assertThatThrownBy(() ->underTest.makeReservation(person, session));
    }

    @Test
    void canCancelAppointmentTest() throws MessagingException {
        // given
        person.addRole(new Role(ADMIN));
        // when
        boolean result = underTest.cancelAppointment(person, appointment);

        // then
        assertThat(appointment.getStatus()).isEqualTo(CANCELED);
        assertTrue(result);
        assertFalse(session.getAppointments().contains(appointment));
    }

    @Test
    void canCancelAppointmentThatWasApprovedTest() throws MessagingException {
        // given
        appointment.setStatus(APPROVED);

        // when
        underTest.cancelAppointment(person, appointment);

        // then
        assertThat(appointment.getStatus()).isEqualTo(CANCELED);
        assertFalse(session.getAppointments().contains(appointment));
        assertTrue(session.getAppointments().isEmpty() ||
                session.getAppointments().stream()
                       .filter(a -> a.getStatus() == APPROVED)
                       .count() == 1L
                );
    }

    @Test
    void tryCancelAppointmentWhenItAlreadyCanceledTest() throws MessagingException {
        // given
        appointment.setStatus(CANCELED);

        // when
        underTest.cancelAppointment(person, appointment);

        // then
        verify(repo, never()).save(appointment);
        verify(repo, never()).saveAndFlush(appointment);
        assertFalse(session.getAppointments().contains(appointment));
    }

    @Test
    void UserCannotCancelAppointmentBefore48HoursTest() throws MessagingException {
        // given
        person.removeRole(providerRole);
        session.setDate(LocalDate.now().plusDays(1));
        // when
        boolean result = underTest.cancelAppointment(person, appointment);
        // then
        assertFalse(result);
        //assertThatThrownBy(() ->underTest.cancelAppointment(person, new Appointment(person, session)));
    }

    @Test
    void SessionExpiredCancelAppointmentTest() throws MessagingException {
        // given
        session.setDate(LocalDate.now().minusDays(1));
        // when
        boolean result = underTest.cancelAppointment(person, appointment);
        // then
        assertFalse(result);
        //assertThatThrownBy(() ->underTest.cancelAppointment(person, new Appointment(person, session)));
    }

    @Test
    void getAllPendingAppointmentsForSessionTest() {
        // when
        List<Appointment> appointments = underTest.getAllPendingAppointmentsForSession(
                person, session);

        // then
        appointments.forEach(a -> {
            assertTrue(a.getStatus() == PENDING);
            assertTrue(a.getSession().equals(session));
        });
    }

    @Test
    void approveAppointmentTest() throws MessagingException {
        // when
        underTest.approveAppointment(person, appointment);

        // then
        assertTrue(appointment.getStatus() == APPROVED);
        verify(repo).save(appointment);
        verify(emailService).sendMessage(any(Person.class), anyString());
    }

    @Test
    void deleteAppointment() {
        // when
        underTest.deleteAppointment(person, appointment);
        // then
        verify(repo).delete(appointment);
        assertFalse(session.getAppointments().contains(appointment));
        assertFalse(person.getAppointments().contains(appointment));
    }

    @Test
    void updateAppointment() {
        // when
        underTest.updateAppointment(person, appointment);
        // then
        verify(repo).save(appointment);
    }

    @Test
    void canGetAppintmentById() {
        // when
        underTest.getAppintmentById(1);
        // then
        verify(repo).findById(1);
    }

    @Test
    void canGetApprovedAppointmentsTest() {
        // when
        List<Appointment> appointments = underTest.getApprovedAppointments();
        // then
        verify(repo).findAll();
        appointments.forEach(
                a -> assertTrue(a.getStatus() == APPROVED)
        );
    }

    @Test
    void canGetCanceledAppointmentsTest() {
        // when
        List<Appointment> appointments = underTest.getCanceledAppointments();
        // then
        verify(repo).findAll();
        appointments.forEach(
                a -> assertTrue(a.getStatus() == CANCELED)
        );
    }

    @Test
    void getAllAppointments() {
        // when
        List<Appointment> appointments = underTest.getAllAppointments();
        // then
        verify(repo).findAll();
    }
}