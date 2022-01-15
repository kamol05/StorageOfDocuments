package com.example.project1.controller;

import com.example.project1.Project1Application;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PreDestroy;

@Controller
public class MainController {

    @GetMapping("")
    public String homePage(){
        return "redirect:/documents";
    }



}
