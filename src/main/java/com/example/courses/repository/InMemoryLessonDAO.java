package com.example.courses.repository;

import com.example.courses.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InMemoryLessonDAO extends JpaRepository<Lesson, Long> {
    Lesson findByName(String name);
}
