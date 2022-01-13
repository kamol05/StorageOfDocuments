package com.example.project1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

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

    @NotEmpty(message = "Поле не может быть пустым.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[\\w])(?=\\S+$).+$",message = "Номер не может состоять только из букв или специальных символов.")
    private String regNumber;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @CreationTimestamp
    private Date regDate;

    @Pattern(regexp = "^$|^(?=.*[0-9])(?=.*[\\w])(?=\\S+$).*$",message = "Номер не может состоять только из букв или специальных символов.")
    private String numOfDoc;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date datedoc;

    private String deliverytype;

    @NotEmpty(message = "Поле не может быть пустым.")
    private String partner;

    @NotEmpty(message = "Поле не может быть пустым.")
    @Size(max = 100)
    @Pattern(regexp = "^$|^(?=\\w+$).*$",message = "Поле формата текст")
    private String theme;

    @Size(max = 1000)
    @Pattern(regexp = "^$|^(?=\\w+$).*$",message = "Поле формата текст")
    private String description;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date timeExecution;

    private boolean access;
    private boolean control;
    private byte[] file;
}
