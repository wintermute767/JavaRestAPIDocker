package com.example.SpringRestAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonV2 extends PersonV1 implements Serializable {


    private Long workExperience;

    private String placeOfResidence;


    public PersonV2() {
    }

    public PersonV2(String firstName, String secondName, Long age, Long height, Long workExperience, String placeOfResidence) {
        super(firstName, secondName, age, height);
        this.workExperience = workExperience;
        this.placeOfResidence = placeOfResidence;
    }
}
