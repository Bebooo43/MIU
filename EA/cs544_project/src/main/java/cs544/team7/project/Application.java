package cs544.team7.project;

import javax.mail.MessagingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws MessagingException, IllegalAccessException {
		SpringApplication.run(Application.class, args);
	}
}
