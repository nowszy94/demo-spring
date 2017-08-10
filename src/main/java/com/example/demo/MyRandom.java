package com.example.demo;

import java.util.Random;

/**
 * Created by Szymon on 2017-08-09.
 */
public class MyRandom extends Random {
    private String message;

    public MyRandom(String message) {
        this.message = message;
    }

    @Override
    public int nextInt(int bound) {
        System.out.println(message);
        return super.nextInt(bound);
    }
}
