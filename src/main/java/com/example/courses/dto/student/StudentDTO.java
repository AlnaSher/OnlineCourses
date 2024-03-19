package com.example.courses.dto.student;

import com.example.courses.dto.course.CourseNameDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private List<CourseNameDTO> courses;
}
