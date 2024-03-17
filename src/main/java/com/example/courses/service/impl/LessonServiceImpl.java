package com.example.courses.service.impl;

import com.example.courses.model.Lesson;
import com.example.courses.model.Student;
import com.example.courses.repository.InMemoryLessonDAO;
import com.example.courses.service.CoursesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LessonServiceImpl implements CoursesService<Lesson> {
    private final InMemoryLessonDAO lessonDAO;

    public LessonServiceImpl(InMemoryLessonDAO lessonDAO) {
        this.lessonDAO = lessonDAO;
    }

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
        Optional<Lesson> ls = lessonDAO.findById(id);
        if(ls.isPresent())
            return ls.get();
        else throw new NoSuchElementException("Lesson not found with ID: " + id);
    }

}
