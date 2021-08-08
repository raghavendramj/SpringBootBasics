package com.upgrad.springbootdemo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private String welcomeMessage = "Hey buddy, Welcome to Spring Boot tutorial in the afternoon";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomeMessage() {
        return this.welcomeMessage;
    }
}
