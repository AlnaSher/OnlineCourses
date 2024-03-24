package com.example.courses.repository;

import com.example.courses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InMemoryCourseDAO extends JpaRepository<Course, Long> {
    @Query("SELECT d FROM Course d WHERE d.name = :name")
    Course findByName(@Param("name") String name);
    boolean existsByName(String name);
}