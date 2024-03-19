package com.example.courses.mapper.lesson;

import com.example.courses.dto.lesson.LessonDTO;
import com.example.courses.mapper.course.CourseNameDTOMapper;
import com.example.courses.model.Lesson;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class LessonDTOMapper implements Function<Lesson, LessonDTO>{
    private final CourseNameDTOMapper courseMapper = new CourseNameDTOMapper();
    @Override
    public LessonDTO apply(Lesson lesson) {
        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setId(lesson.getId());
        lessonDTO.setName(lesson.getName());
        lessonDTO.setCourse(courseMapper.apply(lesson.getCourse()));

        return lessonDTO;
    }
}
