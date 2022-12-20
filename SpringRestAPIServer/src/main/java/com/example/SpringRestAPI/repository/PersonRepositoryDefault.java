package com.example.SpringRestAPI.repository;

import com.example.SpringRestAPI.model.PersonV1;
import lombok.ToString;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@ToString
@Repository
@Profile("prod")
public class PersonRepositoryDefault<T extends PersonV1> implements ObjectRepository <T, Integer> {
    private List<T> repository;

    public PersonRepositoryDefault() {
        this.repository = new ArrayList<>();
    }

    @Override
    public void save(T person) {
        repository.add(person);
    }

    @Override
    public T getById(Integer ID) {

        if (ID < repository.size()) {
            return repository.get(ID);
        }

        return null;
    }

    @Override
    public void deleteById(Integer ID) {
        this.repository.remove(ID);
    }

    @Override
    public void updateById(Integer ID, T person) {
        this.repository.set(ID, person);
    }
}
