package com.otsi.employee.aop;

import java.util.Arrays;





import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

@Aspect
@Component
public class TestAopController {
	
	private Logger logger = Logger.getLogger(this.getClass());

	@Before("execution(* com.otsi.employee.controller.AppController.*(..))")
	public void loggingAdviceBefore(JoinPoint joinPoint){
		System.out.println("**********aop controller###############");
		logger.info("method execution started");
		logger.info(joinPoint.toString());
		
		logger.info(Arrays.toString(joinPoint.getArgs()));

	}
	@After("execution(* com.grabjobit.controller.EmpController.*(..))")
	public void loggingAdviceAfter(JoinPoint joinPoint)
	{
		logger.info("method execution ended");
		logger.info(joinPoint.toString());
		
		logger.info(Arrays.toString(joinPoint.getArgs()));
	}
}
