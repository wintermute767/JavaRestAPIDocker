package com.example.SpringRestAPI.service;

import com.example.SpringRestAPI.model.PersonV1;
import com.example.SpringRestAPI.repository.ObjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceV1Impl implements PersonService <PersonV1> {
    @Autowired
    ObjectRepository personRepository;

    @Override
    public void create(PersonV1 person ) {
        personRepository.save(person );
    }

    @Override
    public PersonV1 read(Integer id) {
        Object person = personRepository.getById(id);
        if (person == null) {
            return null;
        }
        return (PersonV1)  person;
    }

    @Override
    public void delete(Integer id) {
        personRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, PersonV1 person ) {
        personRepository.updateById(id, person );
    }
}