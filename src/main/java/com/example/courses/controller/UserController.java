package com.example.courses.controller;

import com.example.courses.model.Student;
import com.example.courses.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> findAllCourses(){
        return service.read();
    }

    @GetMapping("/find")
    public Student findByName(@RequestParam long id){
        try {
            return service.getById(id);
        }
        catch(NoSuchElementException e){
            return new Student();
        }
    }

    @PostMapping("/addUser")
    public Student addCourse(@RequestBody Student user){
        return service.create(user);
    }
    @PatchMapping("/updateUser")
    public ResponseEntity<String> updateByName(@RequestBody Student user){
        if(service.update(user)){
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
