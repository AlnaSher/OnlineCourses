package com.example.courses.mapper.course;

import com.example.courses.dto.course.CourseNameDTO;
import com.example.courses.model.Course;

import java.util.function.Function;

public class CourseNameDTOMapper implements Function<Course, CourseNameDTO> {
    @Override
    public CourseNameDTO apply(Course course) {
        return new CourseNameDTO(course.getName());
    }
}
