package me.nick.sfw.circular_dependency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BService {

    @Autowired
    private AService aService;

    public void test() {
        System.out.println(aService);
    }
}
