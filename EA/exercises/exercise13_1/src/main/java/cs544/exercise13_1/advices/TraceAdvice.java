package cs544.exercise13_1.advices;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import cs544.exercise13_1.EmailSender;

@Aspect
public class TraceAdvice {

	@After("execution(* cs544.exercise13_1.EmailSender.sendEmail(..)) && args(email, message)")
	public void afterSendMail(JoinPoint joinPoint,String email, String message) {
		System.out.println(new Date() + " method= " + joinPoint.getSignature().getName()+" address= "+email);
		System.out.println("message= " + message);
		System.out.println("outgoing mail server= " + ((EmailSender)joinPoint.getTarget()).getOutgoingMailServer());
	}
}
