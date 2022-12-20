package com.example.SpringRestAPI.service;

import com.example.SpringRestAPI.model.PersonV1;
import com.example.SpringRestAPI.model.PersonV2;
import com.example.SpringRestAPI.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceV2Impl implements PersonService <PersonV2>{
    @Autowired
    ObjectRepository personRepository;

    @Override
    public void create(PersonV2 person ) {
        personRepository.save(person );
    }

    @Override
    public PersonV2 read(Integer id) {
        Object person = personRepository.getById(id);
        if (person == null) {
            return null;
        }
        if (person.getClass()== PersonV1.class){
            PersonV2 newPerson = new PersonV2((PersonV1) person);
            return newPerson;
        }
        return (PersonV2) personRepository.getById(id);
    }

    @Override
    public void delete(Integer id) {
        personRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, PersonV2 person ) {
        personRepository.updateById(id, person );
    }
}