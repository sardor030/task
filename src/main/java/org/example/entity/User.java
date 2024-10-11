package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "book")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String sureName;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false, length = 50)
    private String address;

    @Column(nullable = false)
    private int faculty;

    @Column(nullable = false)
    private int course;

}
