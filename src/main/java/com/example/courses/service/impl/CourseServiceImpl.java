package com.example.courses.service.impl;

import com.example.courses.cache.CacheEntity;
import com.example.courses.dto.course.CourseDTO;
import com.example.courses.dto.lesson.LessonDTO;
import com.example.courses.dto.lesson.LessonNameDTO;
import com.example.courses.dto.student.StudentNameDTO;
import com.example.courses.mapper.course.CourseDTOMapper;
import com.example.courses.model.Course;
import com.example.courses.model.Lesson;
import com.example.courses.model.Student;
import com.example.courses.repository.InMemoryCourseDAO;
import com.example.courses.repository.InMemoryLessonDAO;
import com.example.courses.repository.InMemoryUserDAO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CourseServiceImpl {
    private final InMemoryCourseDAO courseDAO;
    private final InMemoryLessonDAO lessonDAO;
    private final InMemoryUserDAO studentDAO;
    private final CourseDTOMapper mapper;
    private final CacheEntity<Integer, CourseDTO> courseCache;

    public List<CourseDTO> findAllCourses() {
        return courseDAO.findAll().stream().map(mapper).toList();
    }
    public CourseDTO findByName(String name) {
        int hashCode = name.hashCode();
        CourseDTO cachedCourse = courseCache.get(hashCode);
        if(cachedCourse != null)
            return cachedCourse;

        Course course = courseDAO.findByName(name);
        if (course == null) {
            return null;
        }

        return mapper.apply(course);
    }

    public Optional<Course> addCourse(Course course){
        if (courseDAO.existsByName(course.getName())) {
            return Optional.empty();
        }

        List<Lesson> lessons = course.getLessons();
        List<Lesson> allLessons = new ArrayList<>();
        for (Lesson lesson : lessons) {
            Lesson existingLesson = lessonDAO.findByName(lesson.getName());
            if (existingLesson != null) {
                allLessons.add(existingLesson);
            } else {
                Lesson savedLesson = lessonDAO.save(lesson);
                allLessons.add(savedLesson);
            }
        }
        course.setLessons(allLessons);

        List<Student> students = course.getStudents();
        List<Student> allStudents = new ArrayList<>();
        for (Student student : students) {
            Student existingStudent = studentDAO.findByName(student.getName());
            if (existingStudent != null) {
                allStudents.add(existingStudent);
            } else {
                Student savedStudent = studentDAO.save(student);
                allStudents.add(savedStudent);
            }
        }
        course.setStudents(allStudents);

        return Optional.of(courseDAO.save(course));
    }

    public boolean deleteCourseByName(String name) {
        Course course = courseDAO.findByName(name);

        if (course != null) {
            courseCache.remove(name.hashCode());
            lessonDAO.deleteAll(course.getLessons());
            courseDAO.delete(course);
            return true;
        }
        return false;
    }

    public boolean updateCourse(Long id, String name) {
        Optional<Course> courseOptional = courseDAO.findById(id);

        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            courseCache.remove(course.getName().hashCode());
            course.setName(name);
            courseCache.remove(name.hashCode());
            courseDAO.save(course);
            return true;
        }
        return false;
    }
}