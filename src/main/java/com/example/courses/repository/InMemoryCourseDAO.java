package com.example.courses.repository;

import com.example.courses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InMemoryCourseDAO extends JpaRepository<Course, Long> {
    Course findByName(String name);
    boolean existsByName(String name);
}
