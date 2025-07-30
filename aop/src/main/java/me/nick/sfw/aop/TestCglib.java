package me.nick.sfw.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.NoOp;

import me.nick.sfw.aop.service.UserService;

/**
 * cglib动态代理
 */
public class TestCglib {
    public static void main(String[] args) {
        
        UserService target = new UserService();
        // 通过cglib技术
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);

        // 定义额外逻辑，也就是代理逻辑
        enhancer.setCallbacks(new Callback[] { new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                    throws Throwable {
                System.out.println("before...");
                Object result = methodProxy.invoke(target, objects);
                System.out.println("after...");
                return result;
            }
        }, NoOp.INSTANCE }); //NoOp.INSTANCE 什么操作也不做
        enhancer.setCallbackFilter(new CallbackFilter() {

            @Override
            public int accept(Method method) {
                if (method.getName().equals("test")) { //test 方法返回 23行中callback[0]，其他callback[1]
                    return 0;
                }
                return 1;
            }
            
        });

        UserService userService = (UserService) enhancer.create();
        userService.test();
        userService.a();
    }
}
