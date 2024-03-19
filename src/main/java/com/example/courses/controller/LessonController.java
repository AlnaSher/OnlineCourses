package com.example.courses.controller;

import com.example.courses.dto.lesson.LessonDTO;
import com.example.courses.model.Lesson;
import com.example.courses.service.impl.LessonServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/lesson")
public class LessonController {
    private final LessonServiceImpl service;
    private static final String SUCCESS = "Success";

    @GetMapping
    public List<LessonDTO> findAllLessons(){
        return service.findAllLessons();
    }

    @GetMapping("/find")
    public ResponseEntity<LessonDTO> findByName(@RequestParam String name){
        LessonDTO lesson = service.findByName(name);
        if (lesson == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lesson);
    }

    @PostMapping("/addLesson")
    public ResponseEntity<String> addCourse(@RequestBody Lesson lesson){
        Optional<Lesson> savedLesson = service.addLesson(lesson);
        if (savedLesson.isPresent()) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("The lesson with that name already exists", HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping("/update")
    public ResponseEntity<String> updateByName(@RequestParam Long id, @RequestParam String name){
        if(service.updateLesson(id, name)){
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>("Fail update", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete")
    public void deleteByName(@RequestParam long id){
        service.deleteLessonById(id);
    }
}
