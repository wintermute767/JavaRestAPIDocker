package com.example.SpringRestAPI.service;


import com.example.SpringRestAPI.model.PersonV1;

public interface  PersonService <T extends PersonV1> {
    void create(T person );

    T read(Integer id);

    void delete (Integer id);

    void update(Integer id, T person);
}
