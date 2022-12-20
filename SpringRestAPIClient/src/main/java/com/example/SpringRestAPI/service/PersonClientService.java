package com.example.SpringRestAPI.service;

import com.example.SpringRestAPI.model.PersonV1;
import org.springframework.http.HttpStatus;

public interface PersonClientService<T extends PersonV1> {

    T getById(Long id);

    HttpStatus addPerson(T person);

    void updatePerson(Long id, T person);

    void deletePerson(Long id);
}