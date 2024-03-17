package com.example.courses.controller;

import com.example.courses.model.Lesson;
import com.example.courses.service.impl.LessonServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lesson")
@AllArgsConstructor
public class LessonController {
    @Autowired
    private final LessonServiceImpl service;

    @GetMapping
    public List<Lesson> findAllCourses(){
        return service.read();
    }

    @GetMapping("/find")
    public Lesson findByName(@RequestParam long id){
        return service.getById(id);
    }

    @PostMapping("/addLesson")
    public Lesson addCourse(@RequestBody Lesson lesson){
        return service.create(lesson);
    }
    @PatchMapping("/updateLesson")
    public ResponseEntity<String> updateByName(@RequestBody Lesson lesson){
        if(service.update(lesson)){
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Fail", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteByName(@RequestParam long id){
        if(service.delete(id)){
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Fail", HttpStatus.NOT_FOUND);
    }
}
