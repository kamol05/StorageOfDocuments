package com.example.project1.controller;

import com.example.project1.entity.Document;
import com.example.project1.exception.DocumentNotFoundException;
import com.example.project1.service.DocumentService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
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
        model.addAttribute("listdocs", documentList);
        return "documents";
    }

    @GetMapping("/documents/new")
    public String addDocument(Model model){
        model.addAttribute("document",new Document());
        model.addAttribute("pageTitle","Add New Document");
        return "document_form";
    }


    @PostMapping("/documents/save")
    public String save(@Valid Document document,
                       BindingResult result,
                       RedirectAttributes re,
                       MultipartFile multik) throws IOException, DocumentNotFoundException {

        if (multik.getSize() > 0){
            if (!multik.getContentType().equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
                & !multik.getContentType().equals("application/msword")
                & !multik.getContentType().equals("application/pdf") ){
                if (multik.getSize() > 1048870){
                    result.addError(new FieldError("document", "file", "Недопустимый формат и размер файла."));
                } else
                result.addError(new FieldError("document", "file", "Недопустимый формат"));
            } else if (multik.getSize() > 1048870 ){
                result.addError(new FieldError("document", "file", "Размер файла превышает 1Мб."));
            }

        }

        if (document.getId() == null & document.getTimeExecution() != null){
            if (document.getTimeExecution().before(new Date())){
                result.addError(new FieldError("document", "timeExecution", "Срок исполнения не может быть раньше даты регистрации документа."));
            }
        }

        if (document.getId() != null){document.setRegDate(service.getById(document.getId()).getRegDate());}

        if (result.hasErrors()){
            return "document_form";
        }

        document.setFile(multik.getBytes());
        service.save(document);
        re.addFlashAttribute("message","The Document Has Benn Saved Succesfully");
        return "redirect:/documents";
    }

    @GetMapping("/documents/edit/{id}")
    public String ShowEditForm(@PathVariable("id")Integer id, Model model, RedirectAttributes re){
        try {
            Document document = service.getById(id);
            model.addAttribute("document",document);
            model.addAttribute("pagetitle","Edit User ( Id  " + id +")");
            return "document_form";
        } catch (DocumentNotFoundException userNotFounExceptiom) {
            re.addFlashAttribute("message","The Document Has Benn Saved Succesfully");
            return "redirect:/documents";
        }
    }

    @GetMapping("/documents/delete/{id}")
    public String deleteForm(@PathVariable("id")Integer id, RedirectAttributes re){
        try {
            service.delete(id);
            re.addFlashAttribute("message","The Document ID " + id + " has been deleted.");
        } catch (DocumentNotFoundException e) {
            re.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/documents";
    }



}
