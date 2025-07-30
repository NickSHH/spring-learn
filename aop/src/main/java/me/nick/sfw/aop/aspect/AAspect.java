package me.nick.sfw.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AAspect {

	@Pointcut("execution(public void me.nick.sfw.aop.service.OrderService.test())")
	public void a(){

	}

	@Before("a()")
	public void zhouyuBefore(JoinPoint joinPoint) {
		System.out.println("A Aspect");
	}
}
