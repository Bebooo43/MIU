package cs544.team7.project.service;

import cs544.team7.project.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {
    @Mock
    private JmsTemplate jmsTemplate;

    private IEmailService underTest;

    @BeforeEach
    public void setup() {
        underTest = new EmailService(jmsTemplate);
    }

    @Test
    public void canSendMessageTest() {
        Person p = new Person();
        p.setEmail("some@email");
        String m = "some message";
        // when
        underTest.sendMessage(p, m);
        // then
        verify(jmsTemplate).send(anyString(), any(MessageCreator.class));
    }
}