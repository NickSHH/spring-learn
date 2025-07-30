package me.nick.sfw.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import me.nick.sfw.aop.service.UserInterface;
import me.nick.sfw.aop.service.UserService;

/**
 * JDK 动态代理
 */
public class TestJDK {

    public static void main(String[] args) {
        UserService target = new UserService();

        // UserInterface接口的代理对象
        Object proxy = Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[] { UserInterface.class },
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before...");
                        Object result = method.invoke(target, args);
                        System.out.println("after...");
                        return result;
                    }
                });

        UserInterface userService = (UserInterface) proxy;
        userService.test();
    }
}
