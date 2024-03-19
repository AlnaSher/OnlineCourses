package com.example.courses.dto.course;

import com.example.courses.dto.lesson.LessonNameDTO;
import com.example.courses.dto.student.StudentNameDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long id;
    private String name;
    private List<LessonNameDTO> lessons;
    private List<StudentNameDTO> students;
}
