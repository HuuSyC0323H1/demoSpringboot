package com.example.demo.service;

import java.util.Optional;

public interface IGenernateService <T>{
    Iterable<T> findAll();
    Optional<T> findbyID(Long id);

    void save(T t);

    void delete(Long id);
}
