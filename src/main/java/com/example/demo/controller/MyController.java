package com.example.demo.controller;

import com.example.demo.service.CalcService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @Autowired
    private CalcService calcService;

    @RequestMapping(path = {"/one", "/two", "three"}, method = RequestMethod.GET/*, params = {"test", "q"}*/)
    public ModelAndView modelAndView(@RequestParam(required = false, name = "test") String testVariable) {
        return new ModelAndView("home");
    }

    @RequestMapping(path = "/query-add", params = {"a", "b"})
    public ModelAndView add(@RequestParam(name = "a")Integer a, @RequestParam(name = "b")Integer b) {
        System.out.println(calcService.add(a, b));
        return new ModelAndView("home");
    }
}
