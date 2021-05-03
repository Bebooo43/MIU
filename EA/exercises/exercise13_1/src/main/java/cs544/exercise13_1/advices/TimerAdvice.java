package cs544.exercise13_1.advices;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class TimerAdvice {

	@Around("execution(* cs544.exercise13_1.CustomerDAO.save(..))")
	public void afterSendMail(ProceedingJoinPoint call) throws Throwable {		
		StopWatch sw = new StopWatch();
	    sw.start(call.getSignature().getName());
	    call.proceed();
	    sw.stop();
	    
		long totaltime = sw.getLastTaskTimeMillis();
		
		System.out.println("Time to execute "+call.getSignature().getName()+" = "+ totaltime +" ms");
	}
}
