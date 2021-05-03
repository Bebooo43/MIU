package cs544.exercise13_2.bank.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cs544.exercise13_2.bank.logging.ILogger;

@Aspect
public class JMSLoggerAdvice {

	@Autowired
	@Qualifier("logger")
	private ILogger logger;
	
	@After("execution(* cs544.exercise13_2.bank.jms.JMSSender.sendJMSMessage(..)) && args(text)")
	public void afterDaoPackage(JoinPoint joinPoint, String text) {
		logger.log("JMSSender: sending JMS message =" + text);
	}
}
