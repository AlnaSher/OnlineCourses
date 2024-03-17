package com.example.courses.service.impl;

import com.example.courses.model.Course;
import com.example.courses.repository.InMemoryCourseDAO;
import com.example.courses.service.CoursesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CourseServiceImpl implements CoursesService<Course> {
    @Autowired
    private InMemoryCourseDAO courseDAO;
    @Override
    public Course create(Course entity) {
        return courseDAO.save(entity);
    }

    @Override
    public List<Course> read() {
        return courseDAO.findAll();
    }

    @Override
    public boolean update(Course entity) {
        courseDAO.save(entity);
        return true;
    }

    @Override
    public Course getById(long id) {
        return courseDAO.getById(id);
    }

    @Override
    public boolean delete(long id) {
        courseDAO.deleteById(id);
        return true;
    }

}
