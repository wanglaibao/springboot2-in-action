package com.laibao.springboot.springboot2inaction.helloapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laibao wang
 * @date 2018-03-03
 * @version 1.0
 */
@RestController
public class HelloWorldController {

    @GetMapping("")
    String helloWorld() {
        return "Hello World!";
    }
}
