package com.example.btlltw.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "driver")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Driver implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "cmt")
    private String cmt;

    @Column(name = "status")
    private int status;

    @Column(name = "license")
    private String license;

    @Column(name = "typeOfLicense")
    private String typeOfLicense;

    @Column(name = "address")
    private String address;

    @Column(name = "birth", nullable = true)
    private Date birth;

    @Column(name = "seniority")
    private int seniority;
}

