package com.example.courses.service.impl;

import com.example.courses.dto.student.StudentDTO;
import com.example.courses.mapper.student.StudentDTOMapper;
import com.example.courses.model.Course;
import com.example.courses.model.Student;
import com.example.courses.repository.InMemoryCourseDAO;
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
public class UserServiceImpl {
    private final InMemoryUserDAO studentDAO;
    private final InMemoryCourseDAO courseDAO;
    private final StudentDTOMapper mapper;
    public List<StudentDTO> findAllStudents() {
        return studentDAO.findAll().stream().map(mapper).toList();
    }
    public StudentDTO findByName(String name) {
        Student student = studentDAO.findByName(name);
        if (student == null) {
            return null;
        }
        return mapper.apply(student);
    }
    public Optional<Student> addStudent(Student student) {
        if (studentDAO.existsByName(student.getName())) {
            return Optional.empty();
        }

        List<Course> courses = student.getCourses();
        List<Course> allCourses = new ArrayList<>();

        for (Course course : courses) {
            Course existingCourse = courseDAO.findByName(course.getName());
            if (existingCourse != null) {
                allCourses.add(existingCourse);

            } else {
                Course savedCourse = courseDAO.save(course);
                allCourses.add(savedCourse);

            }
        }
        student.setCourses(allCourses);


        return Optional.of(studentDAO.save(student));
    }

    public boolean deleteStudentByName(String name) {
        Student student = studentDAO.findByName(name);
        if (student != null) {
            studentDAO.delete(student);
            return true;
        }
        return false;
    }
    public boolean updateStudent(Long id, String name) {
        Optional<Student> studentOptional = studentDAO.findById(id);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(name);
            studentDAO.save(student);
            return true;
        }
        return false;
    }
}
