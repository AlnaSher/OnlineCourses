package com.example.courses.service;

import java.util.List;
public interface CoursesService<T> {
    T create(T entity);

    List<T> read();

    boolean updateByName(String name, String newName);

    boolean deleteByName(String name);

    T findByName(String name);
}
