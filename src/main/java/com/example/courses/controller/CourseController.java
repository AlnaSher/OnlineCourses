package com.example.courses.controller;

import com.example.courses.model.Course;
import com.example.courses.service.CoursesService;
import com.example.courses.service.impl.CourseServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@AllArgsConstructor
public class CourseController {
    private static CourseServiceImpl service;

    @GetMapping
    public List<Course> findAllCourses(){
        return service.read();
    }

    @GetMapping("/find")
    public Course findByName(@RequestParam String name){
        return service.findByName(name);
    }

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course){
        return service.create(course);
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
