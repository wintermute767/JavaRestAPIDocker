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
public class PersonV2 extends PersonV1 implements Serializable {


    private int workExperience;

    private String placeOfResidence;


    public PersonV2() {
    }
    public PersonV2(PersonV1 person) {
        this.setFirstName(person.getFirstName());
        this.setSecondName(person.getSecondName());
        this.setAge(person.getAge());
        this.setHeight(person.getHeight());
        this.workExperience = 0;
        this.placeOfResidence = "";
    }
    public PersonV2(String firstName, String secondName, int age, int height, int workExperience, String placeOfResidence) {
        super(firstName, secondName, age, height);
        this.workExperience = workExperience;
        this.placeOfResidence = placeOfResidence;
    }
}
