package com.example.courses.mapper.student;

import com.example.courses.dto.student.StudentNameDTO;
import com.example.courses.model.Student;

import java.util.function.Function;

public class StudentNameDTOMapper implements Function<Student, StudentNameDTO> {
    @Override
    public StudentNameDTO apply(Student student) {
        return new StudentNameDTO(student.getName());
    }
}
