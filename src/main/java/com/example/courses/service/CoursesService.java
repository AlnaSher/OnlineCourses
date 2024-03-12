package com.example.courses.service;


import com.example.courses.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CoursesService<T> {
    T create(T entity);

    List<T> read();

    void update(T entity);

    boolean updateByName(String name, String newName);

    boolean deleteByName(String name);
    void delete(Long id);

    T findByName(String name);
}
