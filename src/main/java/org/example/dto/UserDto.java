package org.example.dto;

import lombok.*;
import java.util.Date;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String sureName;
    private Date birthDate;
    private String address;
    private  int faculty;
    private  int course;
}

