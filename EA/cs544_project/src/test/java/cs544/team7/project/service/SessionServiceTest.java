package cs544.team7.project.service;

import cs544.team7.project.model.*;
import cs544.team7.project.repository.SessionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static cs544.team7.project.model.AppointmentStatus.APPROVED;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SessionServiceTest {
    @Mock
    private SessionRepository repo;
    private ISessionService underTest;
    private Session sampleSession;

    @BeforeEach
    void setUp() {
        underTest = new SessionService(repo);
        sampleSession = new Session(LocalDate.now().plusDays(7),
                LocalTime.now(),
                120,
                "Darby Hall",
                new Person("John", "Smith", "jsmith@gmail.com", "jsmith", "p@s$w0rD",
                        new ArrayList<>(Arrays.asList(new Role(RoleType.PROVIDER)))));
    }

    @Test
    void canCreateSessionTest() {
        // when
        underTest.createSession(sampleSession);

        // then
        verify(repo).save(sampleSession);
    }

    @Test
    void lateCreateSessionTest() {
        // given
        sampleSession.setDate(LocalDate.now());

        // when
        // then
        assertThatThrownBy(() -> underTest.createSession(sampleSession));
        verify(repo, never()).save(sampleSession);
    }

    @Test
    void alreadyExistsSessionCreateSessionTest() {
        // given
        when(repo.findById(sampleSession.getId())).thenReturn(java.util.Optional.ofNullable(sampleSession));
        // when
        // then
        assertThatThrownBy(() -> underTest.createSession(sampleSession));
    }

    @Test
    void assignNotProviderCreateSessionTest() {
        // given
        sampleSession.getProvider().removeRole(new Role(RoleType.PROVIDER));

        // when
        // then
        assertThatThrownBy(() -> underTest.createSession(sampleSession));
        verify(repo, never()).save(sampleSession);
    }

    @Test
    void canGetAllSessionsTest() {
        // when
        List<Session> sessions = underTest.getAllSessions();
        // then
        verify(repo).findAll();
    }

    @Test
    void getAllAvailableSessionsTest() {
        sampleSession.setStartTime(LocalTime.now().plusHours(2));
        Appointment appointment2 = new Appointment(new Person(), sampleSession);
        appointment2.setStatus(APPROVED);
        when(repo.findAll()).thenReturn(Arrays.asList(
                sampleSession, new Session(LocalDate.now().plusDays(4),
                        LocalTime.now().plusHours(5),
                        120,
                        "Verril Hall",
                        new Person("Mike", "Doe", "mdoe@gmail.com", "mdoe", "p@s$w0rD",
                                new ArrayList<>(Arrays.asList(new Role(RoleType.PROVIDER)))))
        ));
        // when
        List<Session> sessions = underTest.getAllAvailableSessions();
        // then
        verify(repo).findAll();
        sessions.forEach(session -> {
            // no old sessions
            assertTrue(session.getDate().isAfter(LocalDate.now())
                || (session.getDate().isEqual(LocalDate.now()) && session.getStartTime().isAfter(LocalTime.now()))
            );
            // no approved
            session.getAppointments().forEach(
                    appointment -> assertFalse(appointment.getStatus() == APPROVED)
            );
        });
    }

    @Test
    void getSessionByIdTest() {
        // given
        Optional<Session> ss = java.util.Optional.ofNullable(sampleSession);
        when(repo.findById(1)).thenReturn(ss);
        // when
        Session session = underTest.getSessionById(1);
        // then
        verify(repo).findById(1);
    }

    @Test
    void updateSessionTest() {
        // given
        when(repo.findById(sampleSession.getId())).thenReturn(java.util.Optional.ofNullable(sampleSession));
        // when
        Session s = underTest.updateSession(sampleSession);
        // then
        verify(repo).save(sampleSession);
        assertTrue(sampleSession.equals(s));
    }

    @Test
    void deleteSessionTest() {
        when(repo.findById(sampleSession.getId())).thenReturn(java.util.Optional.ofNullable(sampleSession));
        // when
        underTest.deleteSession(sampleSession);
        // then
        verify(repo).delete(sampleSession);
    }
}