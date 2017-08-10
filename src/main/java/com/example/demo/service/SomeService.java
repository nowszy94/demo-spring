package com.example.demo.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SomeService {
    private String message;

    public SomeService() {
        this.message = RandomStringUtils.random(5, true, false);
        System.out.println("Generated value " + message);
    }

    public void action() {
        System.out.println(message);
    }
}
