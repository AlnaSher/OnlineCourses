package com.example.courses.controller;

import com.example.courses.model.Lesson;
import com.example.courses.service.impl.LessonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lesson")
public class LessonController {
    private final LessonServiceImpl service;

    public LessonController(LessonServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<Lesson> findAllCourses(){
        return service.read();
    }

    @GetMapping("/find")
    public Lesson findByName(@RequestParam String name){
        return service.findByName(name);
    }

    @PostMapping("/addCourse")
    public Lesson addCourse(@RequestBody Lesson lesson){
        return service.create(lesson);
    }
    @PatchMapping("/updateCourse")
    public ResponseEntity<String> updateByName(@RequestParam String name, @RequestParam String newName){
        if(service.updateByName(name, newName)){
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Fail", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteByName(@RequestParam String name){
        if(service.deleteByName(name)){
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Fail", HttpStatus.NOT_FOUND);
    }
}
