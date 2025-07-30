package me.nick.sfw.aop;

import org.springframework.aop.framework.ProxyFactory;

import me.nick.sfw.aop.advice.NickAfterReturningAdvice;
import me.nick.sfw.aop.advice.NickBeforeAdvice;
import me.nick.sfw.aop.advice.NickThrowsAdvice;
import me.nick.sfw.aop.service.UserService;

public class TestProxyFactory {

    public static void main(String[] args) {
        UserService target = new UserService();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new NickBeforeAdvice());
        proxyFactory.addAdvice(new NickAfterReturningAdvice());
        proxyFactory.addAdvice(new NickThrowsAdvice());
        UserService proxy = (UserService) proxyFactory.getProxy();
        proxy.a();
    }
}
