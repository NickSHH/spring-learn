package me.nick.sfw;

import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        /***
         * Bean的创建生命周期
         * UserService.class ---> 无参构造方法(有无参用无参，无无参仅一个构造方法也行，仅有多个有参构造方法报错但可以在想要用的方法上加autowired) --->普通对象--->依赖注入（属性赋值、BeanNameAware接口、BeanClassLoaderAware接口、BeanFactoryAware接口）--->初始化前（postconstruct)--->初始化（initializingBean)--->初始化后（aop)--->代理对象--->Bean
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //UserService userService = context.getBean(UserService.class);
        // userService.test();
        System.out.println("Hello world!");

        System.out.println("NickFactoryBean    :" + context.getBean("nickFactoryBean"));
        System.out.println("NickFactoryBean    :" + context.getBean("nickFactoryBean"));
        System.out.println("NickFactoryBean    :" + context.getBean("nickFactoryBean"));

        System.out.println("NickFactoryBean    :" + context.getBean("&nickFactoryBean"));

        // System.out.println("admin    :" + context.getBean("admin"));

        try {
            UserService userService1 = (UserService) context.getBean("userService");
        } catch (UnsatisfiedDependencyException e) {
            System.err.println(e);
        }
        // context.close();
        
    }
}