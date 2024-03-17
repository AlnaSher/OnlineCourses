package com.example.courses.service.impl;

import com.example.courses.model.Student;
import com.example.courses.repository.InMemoryUserDAO;
import com.example.courses.service.CoursesService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements CoursesService<Student> {
    @Autowired
    private InMemoryUserDAO studentDAO;
    @Override
    public Student create(Student entity) {
        return studentDAO.save(entity);
    }

    @Override
    @Transactional
    public List<Student> read() {
        return studentDAO.findAll();
    }

    @Override
    public boolean update(Student entity) {
        studentDAO.save(entity);
        return true;
    }

    @Override
    public boolean delete(long id) {
        studentDAO.deleteById(id);
        return true;
    }

    @Override
    public Student getById(long id) {
        Optional<Student> st = studentDAO.findById(id);
        if(st.isPresent())
            return st.get();
        else throw new NoSuchElementException("Student not found with ID: " + id);
    }


}
