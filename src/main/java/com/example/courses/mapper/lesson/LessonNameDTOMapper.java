package com.example.courses.mapper.lesson;

import com.example.courses.dto.lesson.LessonNameDTO;
import com.example.courses.model.Lesson;

import java.util.function.Function;

public class LessonNameDTOMapper implements Function<Lesson, LessonNameDTO> {
    @Override
    public LessonNameDTO apply(Lesson lesson) {
        return new LessonNameDTO(lesson.getName());
    }
}
