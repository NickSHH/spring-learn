package me.nick.sfw.circular_dependency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AService {
    @Autowired
    @Lazy
    private BService bService;

    @Async
    public void test() {
        System.out.println(bService);
    }
}
