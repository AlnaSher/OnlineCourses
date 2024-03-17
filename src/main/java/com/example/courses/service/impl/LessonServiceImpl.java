package com.example.courses.service.impl;

import com.example.courses.model.Lesson;
import com.example.courses.repository.InMemoryLessonDAO;
import com.example.courses.service.CoursesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class LessonServiceImpl implements CoursesService<Lesson> {
    @Autowired
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
    public boolean update(Lesson entity) {
        lessonDAO.save(entity);
        return true;
    }

    @Override
    public boolean delete(long id) {
        lessonDAO.deleteById(id);
        return true;
    }

    @Override
    public Lesson getById(long id) {
        return lessonDAO.getById(id);
    }

}
