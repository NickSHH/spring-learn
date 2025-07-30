package me.nick.sfw.aop;

import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import me.nick.sfw.aop.advice.NickAroundAdvice;
import me.nick.sfw.aop.advice.NickAfterReturningAdvice;
import me.nick.sfw.aop.advice.NickBeforeAdvice;
import me.nick.sfw.aop.advice.NickThrowsAdvice;
import me.nick.sfw.aop.service.UserService;

public class TestProxyFactory {

    public static void main(String[] args) {
        UserService target = new UserService();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        // proxyFactory.addAdvice(new NickBeforeAdvice());
        proxyFactory.addAdvisor(new PointcutAdvisor() {

            @Override
            public Advice getAdvice() {
                return new NickBeforeAdvice();
            }

            @Override
            public Pointcut getPointcut() {
                return new StaticMethodMatcherPointcut() {

                    @Override
                    public boolean matches(Method method, Class<?> targetClass) {
                        return method.getName().equals("test"); //仅在方法名为test时执行
                    }
                    
                };
            }
            
        });
        proxyFactory.addAdvice(new NickAroundAdvice());
        proxyFactory.addAdvice(new NickAfterReturningAdvice());
        proxyFactory.addAdvice(new NickThrowsAdvice());
        UserService proxy = (UserService) proxyFactory.getProxy();
        proxy.a();
        proxy.test();
    }
}
