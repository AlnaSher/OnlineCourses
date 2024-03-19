package com.example.courses.dto.lesson;

import com.example.courses.dto.course.CourseNameDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {
    private Long id;
    private String name;
    private CourseNameDTO course;
}
