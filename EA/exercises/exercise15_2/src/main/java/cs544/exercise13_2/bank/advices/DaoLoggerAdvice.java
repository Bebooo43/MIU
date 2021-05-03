package cs544.exercise13_2.bank.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cs544.exercise13_2.bank.logging.ILogger;

@Aspect
public class DaoLoggerAdvice {

	@Autowired
	@Qualifier("logger")
	private ILogger logger;
	
	@After("execution(* cs544.exercise13_2.bank.dao.*.*(..))")
	public void afterDaoPackage(JoinPoint joinPoint) {
		logger.log("calling method: "+joinPoint.getSignature().getName());
	}
}
