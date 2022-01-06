package com.example.project1.service;

import com.example.project1.entity.Store;
import com.example.project1.entity.StoreDocRepository;
import com.example.project1.exception.StoreNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    private StoreDocRepository rep;

    public void save(Store storeDoc){
        rep.save(storeDoc);
    }

    public List<Store> listAll(){
        return (List<Store>) rep.findAll();
    }

    public Store getById(Integer id) throws StoreNotFoundException {
        Optional<Store> result = rep.findById(id);
        if (result.isPresent()){
            return result.get();
        } throw new StoreNotFoundException("User Not Found");
    }

    public void delete(Integer id) throws StoreNotFoundException {
        Integer count = rep.countById(id);
        if (count == null || count == 0){
            throw new StoreNotFoundException("Not Found User With Id " + id);
        }
        rep.deleteById(id);
    }
}
