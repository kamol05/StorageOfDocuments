package com.example.project1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    private int regNumber;
    @Type(type="date")
    private Date regDate;
    private int numOfDoc;
    @Type(type="date")
    private Date datedoc;
    private String deliverytype;
    private String partner;
    private String theme;
    private String description;
    @Type(type="date")
    private Date timeExecution;
    private boolean access;
    private boolean control;
    private byte[] file;

}
