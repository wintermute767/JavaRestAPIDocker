package com.example.SpringRestAPI.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;




@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PersonV1 implements Serializable {

    private String firstName;

    private String secondName;

    private int age;

    private int height;

    public PersonV1() {
    }

    public PersonV1(String firstName, String secondName, int age, int height) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.height = height;
    }
}
