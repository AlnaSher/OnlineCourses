package com.example.courses.repository;

import com.example.courses.model.Course;
import com.example.courses.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InMemoryUserDAO extends JpaRepository<User, Long> {
    User findByName(String name);
}
