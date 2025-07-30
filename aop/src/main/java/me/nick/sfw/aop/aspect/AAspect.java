package me.nick.sfw.aop.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AAspect {

    @Before("execution(public void me.nick.sfw.circular_dependency.service.AService.test())")
    public void aBefore(Joinpoint joinpoint) {
        System.out.println("A Aspect");
    }
}
