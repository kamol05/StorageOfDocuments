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
import java.util.Arrays;
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
    private String theme;

    @Size(max = 1000)
    private String description;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date timeExecution;

    private boolean access;
    private boolean control;
    private byte[] file;
    private String filename;
    private String fileType;

    public int getFileSize() {
        if (file != null){
        return file.length;
        } else return 0;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", regNumber='" + regNumber + '\'' +
                ", regDate=" + regDate +
                ", numOfDoc='" + numOfDoc + '\'' +
                ", datedoc=" + datedoc +
                ", deliverytype='" + deliverytype + '\'' +
                ", partner='" + partner + '\'' +
                ", theme='" + theme + '\'' +
                ", description='" + description + '\'' +
                ", timeExecution=" + timeExecution +
                ", access=" + access +
                ", control=" + control +
                ", file=" + Arrays.toString(file) +
                '}';
    }
}
