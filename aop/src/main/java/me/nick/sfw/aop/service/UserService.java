package me.nick.sfw.aop.service;

import org.springframework.stereotype.Component;

@Component
public class UserService implements UserInterface{


    public void test() {
        System.out.println("123");
    }

    public void a() {
        System.out.println("000");
        throw new NullPointerException();
    }

}
