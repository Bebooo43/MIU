package cs544.team7.project.service;

import cs544.team7.project.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class EmailService implements IEmailService {
    private JmsTemplate jmsTemplate;

    @Autowired
    public EmailService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    @Override
    public void sendMessage(Person person, String message) {
        jmsTemplate.send("log", new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(
                        "to: " + person.getEmail() + ", message: " + message
                );
            }
        });
    }
}
