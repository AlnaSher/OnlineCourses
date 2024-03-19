package com.example.courses.mapper.course;

import com.example.courses.dto.course.CourseDTO;
import com.example.courses.dto.lesson.LessonNameDTO;
import com.example.courses.dto.student.StudentNameDTO;
import com.example.courses.model.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class CourseDTOMapper implements Function<Course, CourseDTO> {
    @Override
    public CourseDTO apply(Course course) {
        List<StudentNameDTO> students = course.getStudents().stream().map(student -> new StudentNameDTO(student.getName())).toList();
        List<LessonNameDTO> lessons = course.getLessons().stream().map(lesson -> new LessonNameDTO(lesson.getName())).toList();

        return new CourseDTO(course.getId(), course.getName(), lessons, students);
    }
}
