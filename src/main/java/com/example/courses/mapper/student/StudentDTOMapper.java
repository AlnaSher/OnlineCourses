package com.example.courses.mapper.student;

import com.example.courses.dto.course.CourseNameDTO;
import com.example.courses.dto.student.StudentDTO;
import com.example.courses.model.Course;
import com.example.courses.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
@Component
public class StudentDTOMapper implements Function<Student, StudentDTO> {
    @Override
    public StudentDTO apply(Student student) {
        List<CourseNameDTO> courses = new ArrayList<>();
        for (Course course : student.getCourses()) {
            CourseNameDTO courseNameDTO = new CourseNameDTO(course.getName());
            courses.add(courseNameDTO);
        }
        return new StudentDTO(student.getId(), student.getName(), courses);
    }
}
