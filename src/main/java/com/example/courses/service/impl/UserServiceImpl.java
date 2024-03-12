package com.example.courses.service.impl;

import com.example.courses.model.Course;
import com.example.courses.model.User;
import com.example.courses.repository.InMemoryUserDAO;
import com.example.courses.service.CoursesService;

import java.util.List;

public class UserServiceImpl implements CoursesService<User> {
    private InMemoryUserDAO userDAO;
    @Override
    public User create(User entity) {
        return userDAO.save(entity);
    }

    @Override
    public List<User> read() {
        return userDAO.findAll();
    }

    @Override
    public void update(User entity) {
        userDAO.save(entity);
    }

    @Override
    public boolean updateByName(String name, String newName) {
        User existing = userDAO.findByName(name);
        if(null != existing){
            existing.setName(newName);
            userDAO.save(existing);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByName(String name) {
        User deleted = userDAO.findByName(name);
        if(null != deleted){
            userDAO.delete(deleted);
            return true;
        }
        return false;
    }

    @Override
    public void delete(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public User findByName(String name) {
        return userDAO.findByName(name);
    }
}
