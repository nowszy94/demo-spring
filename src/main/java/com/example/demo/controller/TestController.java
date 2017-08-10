package com.example.demo.controller;

import com.example.demo.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @Autowired
    private SomeService someService;

    @Autowired
    private SomeService someService2;

    @RequestMapping(path = "/test1")
    public ModelAndView test() {
        someService.action();
        return new ModelAndView("home");
    }

    @RequestMapping(path = "/test2")
    public ModelAndView test2() {
        someService.action();
        return new ModelAndView("home");
    }
}
