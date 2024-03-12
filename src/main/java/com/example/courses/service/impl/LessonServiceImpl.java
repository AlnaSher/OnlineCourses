package com.example.courses.service.impl;

import com.example.courses.model.Course;
import com.example.courses.model.Lesson;
import com.example.courses.model.User;
import com.example.courses.repository.InMemoryLessonDAO;
import com.example.courses.service.CoursesService;

import java.util.List;

public class LessonServiceImpl implements CoursesService<Lesson> {
    private InMemoryLessonDAO lessonDAO;
    @Override
    public Lesson create(Lesson entity) {
        return lessonDAO.save(entity);
    }

    @Override
    public List<Lesson> read() {
        return lessonDAO.findAll();
    }

    @Override
    public void update(Lesson entity) {
        lessonDAO.save(entity);
    }

    @Override
    public boolean updateByName(String name, String newName) {
        Lesson existing = lessonDAO.findByName(name);
        if(null != existing){
            existing.setName(newName);
            lessonDAO.save(existing);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByName(String name) {
        Lesson deleted = lessonDAO.findByName(name);
        if(null != deleted){
            lessonDAO.delete(deleted);
            return true;
        }
        return false;
    }

    @Override
    public void delete(Long id) {
        lessonDAO.deleteById(id);
    }

    @Override
    public Lesson findByName(String name) {
        return lessonDAO.findByName(name);
    }
}
