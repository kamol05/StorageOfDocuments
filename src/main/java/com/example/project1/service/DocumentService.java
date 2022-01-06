package com.example.project1.service;

import com.example.project1.entity.Document;
import com.example.project1.entity.StoreDocRepository;
import com.example.project1.exception.DocumentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    private StoreDocRepository rep;

    public void save(Document documentDoc){
        rep.save(documentDoc);
    }

    public List<Document> listAll(){
        return (List<Document>) rep.findAll();
    }

    public Document getById(Integer id) throws DocumentNotFoundException {
        Optional<Document> result = rep.findById(id);
        if (result.isPresent()){
            return result.get();
        } throw new DocumentNotFoundException("User Not Found");
    }

    public void delete(Integer id) throws DocumentNotFoundException {
        Integer count = rep.countById(id);
        if (count == null || count == 0){
            throw new DocumentNotFoundException("Not Found User With Id " + id);
        }
        rep.deleteById(id);
    }
}
