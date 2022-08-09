package com.example.hk_rest_crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @JsonIgnore
    private int id;

    private String fullName;
    private String job;
    private String city;
}
