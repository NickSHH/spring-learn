package me.nick.sfw.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.lang.Nullable;

public class NickAfterReturningAdvice implements AfterReturningAdvice{

    @Override
    public void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target)
            throws Throwable {
        System.out.println("方法返回后执行");
    }

}
