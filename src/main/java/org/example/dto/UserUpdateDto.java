package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserUpdateDto {
    private int id;
    private String name;
    private String sureName;
    private Date birthDate;
    private String address;
    private  int faculty;
    private  int course;
}

