package com.example.SpringRestAPI.repository;


public interface ObjectRepository<T, ID> {

    public void save(T t);
    public T getById(ID id);
    public void deleteById(ID id);
    public void updateById(ID id,T t);
}