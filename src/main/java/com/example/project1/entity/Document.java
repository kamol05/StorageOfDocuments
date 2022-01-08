package com.example.project1.entity;

import jdk.jfr.Timespan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

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

    private String regNumber;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @CreationTimestamp
    private Date regDate;
    private String numOfDoc;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date datedoc;
    private String deliverytype;
    private String partner;
    private String theme;
    private String description;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date timeExecution;
    private boolean access;
    private boolean control;
    private byte[] file;

}
