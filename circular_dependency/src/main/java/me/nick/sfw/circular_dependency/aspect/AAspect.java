package me.nick.sfw.circular_dependency.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AAspect {

    @Before("execution(public void me.nick.sfw.circular_dependency.service.AService.test())")
    public void aBefore(Joinpoint joinpoint) {
        System.out.println("A Aspect");
    }
}
