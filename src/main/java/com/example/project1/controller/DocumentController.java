package com.example.project1.controller;

import com.example.project1.entity.Document;
import com.example.project1.service.DocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DocumentController {

    private DocumentService service;

    public DocumentController(DocumentService service) {
        this.service = service;
    }

    @GetMapping("/documents")
    public String documents(Model model){
        List<Document> documentList = service.listAll();
        model.addAttribute("listUsers", documentList);
        return "documents";
    }


}
