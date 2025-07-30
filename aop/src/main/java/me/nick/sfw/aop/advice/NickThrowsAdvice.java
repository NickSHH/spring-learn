package me.nick.sfw.aop.advice;



import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class NickThrowsAdvice implements ThrowsAdvice{

    public void afterThrowing(Method method, Object[] args, Object target, NullPointerException ex) {
        System.out.println("方法抛出异常后执行");
    }

}
