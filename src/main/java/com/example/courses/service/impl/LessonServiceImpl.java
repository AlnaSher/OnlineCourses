package com.example.courses.service.impl;

import com.example.courses.dto.lesson.LessonDTO;
import com.example.courses.mapper.lesson.LessonDTOMapper;
import com.example.courses.model.Course;
import com.example.courses.model.Lesson;
import com.example.courses.repository.InMemoryCourseDAO;
import com.example.courses.repository.InMemoryLessonDAO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class LessonServiceImpl {
    private final InMemoryLessonDAO lessonDAO;
    private final InMemoryCourseDAO courseDAO;
    private final LessonDTOMapper mapper;
    public List<LessonDTO> findAllLessons() {
        return lessonDAO.findAll().stream().map(mapper).toList();
    }
    public LessonDTO findByName(String name) {
        Lesson lesson = lessonDAO.findByName(name);
        if (lesson == null) {
            return null;
        }
        return mapper.apply(lesson);
    }
    public Optional<Lesson> addLesson(Lesson lesson) {
        Course course = lesson.getCourse();
        Course existingCourse = courseDAO.findByName(course.getName());

        if (existingCourse != null) {
            lesson.setCourse(existingCourse);
        } else {
            Course savedCourse = courseDAO.save(course);
            lesson.setCourse(savedCourse);
        }
        return Optional.of(lessonDAO.save(lesson));
    }

    public void deleteLessonById(Long id) {

        lessonDAO.deleteById(id);
    }
    public boolean updateLesson(Long id, String name) {
        Optional<Lesson> lessonOptional = lessonDAO.findById(id);

        if (lessonOptional.isPresent()) {
            Lesson lesson = lessonOptional.get();
            lesson.setName(name);
            lessonDAO.save(lesson);
            return true;
        }
        return false;
    }
}
