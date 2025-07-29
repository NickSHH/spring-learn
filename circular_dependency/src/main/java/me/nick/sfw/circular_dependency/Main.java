package me.nick.sfw.circular_dependency;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.nick.sfw.circular_dependency.service.AService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setAllowCircularReferences(false); //disable Circular Dependency
        ctx.refresh();
        AService aService = (AService) ctx.getBean("AService");
        aService.test();
    }
}