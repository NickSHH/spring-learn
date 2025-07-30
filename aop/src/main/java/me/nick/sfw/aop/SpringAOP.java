package me.nick.sfw.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.nick.sfw.aop.service.OrderService;
import me.nick.sfw.aop.service.UserInterface;
public class SpringAOP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserInterface userService = (UserInterface) ctx.getBean("userService"); //JDK动态代理需要至少实现一个接口
        userService.test();

        OrderService orderService = (OrderService) ctx.getBean("orderService");
        orderService.test();
    }
}