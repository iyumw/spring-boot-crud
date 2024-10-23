package com.example.trabalho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Hello {
    @GetMapping("/index")
    public String hello() {
        return "index.html";
    }
}
