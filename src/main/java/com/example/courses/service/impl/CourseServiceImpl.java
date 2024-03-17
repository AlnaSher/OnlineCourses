package com.example.courses.service.impl;

import com.example.courses.model.Course;
import com.example.courses.repository.InMemoryCourseDAO;
import com.example.courses.service.CoursesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CoursesService<Course> {
    private final InMemoryCourseDAO courseDAO;

    public CourseServiceImpl(InMemoryCourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

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
        Optional<Course> cs = courseDAO.findById(id);
        if(cs.isPresent())
            return cs.get();
        else throw new NoSuchElementException("Course not found with ID: " + id);
    }

    @Override
    public boolean delete(long id) {
        courseDAO.deleteById(id);
        return true;
    }

}
