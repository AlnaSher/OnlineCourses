package com.example.courses.repository;

import com.example.courses.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InMemoryUserDAO extends JpaRepository<Student, Long> {
    @Query("SELECT d FROM Student d WHERE d.name = :name")
    Student findByName(@Param("name")String name);
    boolean existsByName(String name);
}
