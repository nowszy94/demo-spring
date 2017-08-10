package com.example.demo.controller;

import com.example.demo.service.SomeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScopeRequestController {

    @Autowired
    private SomeRequestService someRequestService;

    @RequestMapping(path = "/request-test")
    public ModelAndView requestTest() {
        someRequestService.doSomething();
        return new ModelAndView("home");
    }

    @RequestMapping(path = "/request-test2")
    public ModelAndView requestTest2() {
        someRequestService.doSomething();
        someRequestService.doSomething();
        someRequestService.doSomething();
        someRequestService.doSomething();
        return new ModelAndView("home");
    }
}
