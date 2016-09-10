package kr.co.saramin.mysite.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MeasureExecutionTimeAspect {
	
	@Around("execution(* *..service.*.*(..) || * *..dao.*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object result = pjp.proceed();
		
		sw.stop();
		
		String task = pjp.getTarget().getClass() + "." + pjp.getSignature().getName();
		
		System.out.println("[" + task + "] " + sw.getTotalTimeMillis() + " millis");
		
		return result;
	}
}
