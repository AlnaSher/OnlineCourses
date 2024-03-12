package com.example.courses.controller;

import com.example.courses.model.User;
import com.example.courses.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserServiceImpl service;
    @GetMapping
    public List<User> findAllCourses(){
        return service.read();
    }

    @GetMapping("/find")
    public User findByName(@RequestParam String name){
        return service.findByName(name);
    }

    @PostMapping("/addCourse")
    public User addCourse(@RequestBody User user){
        return service.create(user);
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
