package com.example.courses.repository;

import com.example.courses.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InMemoryUserDAO extends JpaRepository<Student, Long> {
    Student findByName(String name);
}
