package me.nick.sfw.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class UserService implements UserInterface{

    public void test() {
        System.out.println("userService test");
    }

    public void a() {
        System.out.println("userService a");
    }


}
