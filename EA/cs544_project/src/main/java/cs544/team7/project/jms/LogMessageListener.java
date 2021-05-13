package cs544.team7.project.jms;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class LogMessageListener implements MessageListener {

	@Value("${emailProducer}")
    String emailProducer;
    @Value("${passwordEmailProducer}")
    String passwordEmailProducer;
    
    @JmsListener(destination = "log")
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
            	String messageString = ((TextMessage) message).getText();
                log.info("Message sent "+messageString);  
                
                //Is better use: Spring JmsTemplate convertAndSend() and receiveAndConvert()
                //String to = messageString.substring(messageString.indexOf(':') + 2, messageString.indexOf(','));
                //String body = messageString.substring(messageString.indexOf(',') + 11, messageString.length());
                //sendEmail(to,body);
            }
            catch (/*MessagingException | */JMSException ex) {
                throw new RuntimeException(ex);
            }
        }
        else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }
    
    private void sendEmail(String to, String body) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");//25

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailProducer, passwordEmailProducer);
            }
        });
        javax.mail.Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(to, false));

        msg.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(to));
        msg.setSubject("CSS544 Subject");
        //msg.setContent(email.getBody(), "text/html"); other way to set the content without multipart
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(body, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        /**
         #send image
         MimeBodyPart attachPart = new MimeBodyPart();
         attachPart.attachFile("/var/tmp/image19.png");
         multipart.addBodyPart(attachPart);
         */

        msg.setContent(multipart);
        Transport.send(msg);
    }
}
