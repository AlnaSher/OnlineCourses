package com.example.courses.repository;

import com.example.courses.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InMemoryLessonDAO extends JpaRepository<Lesson, Long> {
    @Query("SELECT d FROM Lesson d WHERE d.name = :name")
    Lesson findByName(@Param("name") String name);
    boolean existsById(long id);
}