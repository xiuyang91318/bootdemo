package com.example.bootdemo.com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBootController {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("test**********************");
        return "Hello Spring Boot";
    }

}
