package com.example.courses.service;


import java.util.List;
@org.springframework.stereotype.Service
public interface Service<T> {
    void create(T entity);

    List<T> read();

    void update(T entity);

    void delete(Long id);

}
