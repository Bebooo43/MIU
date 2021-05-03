package cs544.exercise11_1;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	
    static Logger logger = Logger.getLogger(Greeting.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new
				 ClassPathXmlApplicationContext("springconfig.xml");
				 Greeting greetingService =
				 context.getBean("greetingService", Greeting.class);
				 logger.warn(greetingService);
				 greetingService.sayHello(); 
	}
}
