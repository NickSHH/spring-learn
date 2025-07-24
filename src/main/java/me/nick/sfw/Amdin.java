package me.nick.sfw;

import org.springframework.stereotype.Component;

@Component
public class Amdin {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amdin() {
        System.out.println("create bean Admin");
    }
}
