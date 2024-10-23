package com.example.trabalho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Teste {
    @GetMapping("/index")
    public String hello() {
        return "index.html";
    }
}
