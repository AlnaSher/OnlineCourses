package com.example.courses.controller;

import com.example.courses.dto.course.CourseDTO;
import com.example.courses.model.Course;
import com.example.courses.service.impl.CourseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseServiceImpl service;
    private static final String SUCCESS = "Success";

    @GetMapping
    public List<CourseDTO> findAllCourses(){
        return service.findAllCourses();
    }

    @GetMapping("/find")
    public ResponseEntity<CourseDTO> findByName(@RequestParam String name){
        CourseDTO course = service.findByName(name);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);
    }

    @PostMapping("/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody Course course){
        Optional<Course> savedCourse = service.addCourse(course);
        if (savedCourse.isPresent()) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("The course with that name already exists", HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping("/update")
    public ResponseEntity<String> updateByName(@RequestParam Long id, @RequestParam String name){
        if(service.updateCourse(id, name)){
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>("Fail update", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteByName(@RequestParam String name){
        if(service.deleteCourseByName(name)){
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to delete", HttpStatus.NOT_FOUND);
    }
}
