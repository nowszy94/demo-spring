package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalcService {

    @Autowired
    private SomeService someService;

    public int add(int a, int b) {
        someService.action();
        return a + b;
    }
}
