package com.example.project1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    private int regNumber;
    private Date regDate;
    private int numOfDoc;
    private Date datedoc;

    @ElementCollection
    @CollectionTable(name = "Delivery",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "deliverytype")
    private List<String> deliveryType;

    @ElementCollection
    @CollectionTable(name = "Parnter",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "parnter")
    private List<String> parnter;

    private String theme;
    private String description;
    private Date timeExecution;
    private boolean access;
    private boolean control;
    private byte[] file;

}
