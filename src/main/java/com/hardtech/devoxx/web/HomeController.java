package com.hardtech.devoxx.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @Value("${conference.name:devoxx}")
    private String conference;

    @RequestMapping("/")
    public String hello() {
        return "hello " + conference;
    }

}
