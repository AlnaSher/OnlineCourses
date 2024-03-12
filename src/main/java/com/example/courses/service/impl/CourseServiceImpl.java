package com.example.courses.service.impl;

import com.example.courses.model.Course;
import com.example.courses.model.User;
import com.example.courses.repository.InMemoryCourseDAO;
import com.example.courses.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseServiceImpl implements CoursesService<Course> {
    @Autowired
    private InMemoryCourseDAO courseDAO;
    @Override
    public Course findByName(String name){
        return courseDAO.findByName(name);
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
    public void update(Course entity) {
        courseDAO.save(entity);
    }

    @Override
    public boolean updateByName(String name, String newName) {
        Course existing = courseDAO.findByName(name);
        if(null != existing){
            existing.setName(newName);
            courseDAO.save(existing);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByName(String name) {
        Course deleted = courseDAO.findByName(name);
        if(null != deleted){
            courseDAO.delete(deleted);
            return true;
        }
        return false;
    }

    @Override
    public void delete(Long id) {
        courseDAO.deleteById(id);
    }
}
