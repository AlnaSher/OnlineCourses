package com.example.courses.mapper.course;

import com.example.courses.dto.course.CourseDTO;
import com.example.courses.dto.lesson.LessonNameDTO;
import com.example.courses.dto.student.StudentNameDTO;
import com.example.courses.model.Course;
import com.example.courses.model.Lesson;
import com.example.courses.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class CourseDTOMapper implements Function<Course, CourseDTO> {
    @Override
    public CourseDTO apply(Course course) {
        List<StudentNameDTO> students = new ArrayList<>();
        for (Student student : course.getStudents()) {
            StudentNameDTO studentNameDTO = new StudentNameDTO(student.getName());
            students.add(studentNameDTO);
        }

        List<LessonNameDTO> lessons = new ArrayList<>();
        for (Lesson lesson : course.getLessons()) {
            LessonNameDTO lessonNameDTO = new LessonNameDTO(lesson.getName());
            lessons.add(lessonNameDTO);
        }

        return new CourseDTO(course.getId(), course.getName(), lessons, students);
    }
}
