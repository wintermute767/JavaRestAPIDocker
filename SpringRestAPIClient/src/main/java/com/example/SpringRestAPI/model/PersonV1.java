package com.example.SpringRestAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonV1 implements Serializable {

    private String firstName;

    private String secondName;

    private Long age;

    private Long height;

    public PersonV1() {
    }

    public PersonV1(String firstName, String secondName, Long age, Long height) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.height = height;
    }
}
