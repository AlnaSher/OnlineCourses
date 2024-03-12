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

}
