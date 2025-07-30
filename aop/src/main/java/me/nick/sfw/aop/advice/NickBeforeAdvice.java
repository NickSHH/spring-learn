package me.nick.sfw.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

public class NickBeforeAdvice implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
        System.out.println("方法前执行");
    }

}
