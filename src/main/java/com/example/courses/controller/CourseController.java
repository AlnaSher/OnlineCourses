package com.example.courses.controller;

import com.example.courses.model.Course;
import com.example.courses.service.impl.CourseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseServiceImpl service;

    public CourseController(CourseServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<Course> findAllCourses(){
        return service.read();
    }

    @GetMapping("/find")
    public Course findById(@RequestParam long id){
        try {
            return service.getById(id);
        }
        catch(NoSuchElementException e){
            return new Course();
        }
    }

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course){
        return service.create(course);
    }
    @PatchMapping("/updateCourse")
    public ResponseEntity<String> updateByName(@RequestBody Course course){
        if(service.update(course)){
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
