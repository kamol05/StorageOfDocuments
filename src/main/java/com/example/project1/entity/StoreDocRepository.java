package com.example.project1.entity;

import org.springframework.data.repository.CrudRepository;

public interface StoreDocRepository extends CrudRepository<Document,Integer> {
    Integer countById (Integer id);

}
