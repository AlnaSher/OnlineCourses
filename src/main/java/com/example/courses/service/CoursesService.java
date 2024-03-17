package com.example.courses.service;

import java.util.List;
public interface CoursesService<T> {
    T create(T entity);

    List<T> read();

    boolean update(T entity);

    boolean delete(long id);

    T getById(long id);
}
