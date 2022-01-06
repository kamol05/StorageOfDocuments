package com.example.project1.controller;

import com.example.project1.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {

    private StoreService service;

    public StoreController(StoreService service) {
        this.service = service;
    }

    @GetMapping("/documents")
    public String documents(){
        return null;
    }
}
