package com.example.demo;

import com.example.demo.service.HomeService;
import com.example.demo.service.RandomGeneratorService;
import com.example.demo.service.StringGeneratorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.util.Random;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public HomeService homeService() {
        HomeService homeService = new HomeService("Hello world from bean");
        return homeService;
    }

    @Bean
    public Random random() {
        return new MyRandom("Hello World from random");
    }

//    @Profile("dev")
    @Bean
    public RandomGeneratorService randomGeneratorService(Random random) {
        RandomGeneratorService randomGeneratorService =
                new RandomGeneratorService(random);
        randomGeneratorService.setBound(100);
        randomGeneratorService.setShift(10);
        return randomGeneratorService;
    }

//    @Profile("prod")
    @Bean
    public RandomGeneratorService bigGenerator(Random random) {
        RandomGeneratorService randomGeneratorService =
                new RandomGeneratorService(random);
        randomGeneratorService.setBound(10000);
        randomGeneratorService.setShift(100);
        return randomGeneratorService;
    }

    @Bean
    public StringGeneratorService lettersGenerator() {
        StringGeneratorService stringGeneratorService = new StringGeneratorService();
        stringGeneratorService.setLetters(true);
        stringGeneratorService.setNumbers(false);
        return stringGeneratorService;
    }

    @Bean
    public StringGeneratorService numbersGenerator() {
        StringGeneratorService stringGeneratorService = new StringGeneratorService();
        stringGeneratorService.setLetters(false);
        stringGeneratorService.setNumbers(true);
        return stringGeneratorService;
    }

    @Bean
    public StringGeneratorService bothGenerator() {
        StringGeneratorService stringGeneratorService = new StringGeneratorService();
        stringGeneratorService.setLetters(true);
        stringGeneratorService.setNumbers(true);
        return stringGeneratorService;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println();
    }
}
