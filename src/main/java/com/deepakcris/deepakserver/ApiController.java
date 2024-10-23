package com.deepakcris.deepakserver;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class ApiController {

    // GET endpoint to return a simple message
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

}