package me.nick.sfw.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.nick.sfw.mvc.service.NickService;

@RestController
public class NickController {
    @Autowired
    private NickService nickService;

    @GetMapping("/test")
    public String test() {
        return nickService.test();
    }

}
