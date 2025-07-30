package me.nick.sfw.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class NickAroundAdvice implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("方法执行Around前");
        Object proceed = invocation.proceed();
        System.out.println("方法执行Around后");
        return proceed;
    }

}
