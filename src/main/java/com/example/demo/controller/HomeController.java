package com.example.demo.controller;

import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private CalcService calcService;

    @Autowired
    private RandomGeneratorService randomGeneratorService;

    @Autowired
    private StringGeneratorService stringGeneratorService;

    @Autowired
    private StringGeneratorService lettersGenerator;

    @Autowired
    private StringGeneratorService numbersGenerator;

    @Autowired
    private List<StringGeneratorService> list;

    @Autowired
    private SomeService someService;

    @RequestMapping(path = "/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        this.homeService.doSomething();
        someService.action();
        return modelAndView;
    }

    @RequestMapping(path = "/add")
    public ModelAndView test() {
        int first = randomGeneratorService.generateRandom();
        int second = randomGeneratorService.generateRandom();
        int result = calcService.add(first, second);
        someService.action();
        System.out.println(result);
        return new ModelAndView("home");
    }

    @RequestMapping(path = "/random-string")
    public ModelAndView randomString() {
        int size = randomGeneratorService.generateRandom();
        String value = stringGeneratorService.generateString(size);
        System.out.println(value);

        return new ModelAndView("home");
    }

    @RequestMapping(path = "/random-letters")
    public ModelAndView randomLetters() {
        int size = randomGeneratorService.generateRandom();
        String value = lettersGenerator.generateString(size);
        System.out.println(value);

        return new ModelAndView("home");
    }

    @RequestMapping(path = "/random-numbers")
    public ModelAndView randomNumbers() {
        int size = randomGeneratorService.generateRandom();
        String value = numbersGenerator.generateString(size);
        System.out.println(value);

        return new ModelAndView("home");
    }

    @RequestMapping(path = "/random-all")
    public ModelAndView randomAll() {
        int size = randomGeneratorService.generateRandom();

//        list.stream()
//                .map(e -> e.generateString(size))
//                .forEach(e -> System.out.println(e));
        list.forEach(e -> System.out.println(e.generateString(size)));

        return new ModelAndView("home");
    }

//    modelAndView.addObject("user", userRepository.findOne(0l))
//    <h1 th:text="${user.lastname}">randomGeneratorService</h1>

}
