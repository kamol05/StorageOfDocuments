package com.example.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String homePage(){
        return "index";
    }

    @GetMapping("/test")
    public String homePag(){
        return "test";
    }
}
