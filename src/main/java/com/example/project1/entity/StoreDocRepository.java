package com.example.project1.entity;

import org.springframework.data.repository.CrudRepository;

public interface StoreDocRepository extends CrudRepository<Store,Integer> {
    Integer countById (Integer id);

}
