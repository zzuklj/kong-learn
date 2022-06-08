package com.klj.konglearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public void hello(){
        System.out.println("hello klj1!");
        System.out.println("hello jrebel!");
        IntStream.range(1,10).forEach(System.out::println);
    }
}
