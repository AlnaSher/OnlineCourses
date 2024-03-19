package com.example.courses.controller;

import com.example.courses.dto.student.StudentDTO;
import com.example.courses.model.Student;
import com.example.courses.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserServiceImpl service;
    private static final String SUCCESS = "Success";

    @GetMapping
    public List<StudentDTO> findAllStudents(){
        return service.findAllStudents();
    }

    @GetMapping("/find")
    public ResponseEntity<StudentDTO> findByName(@RequestParam String name){
        StudentDTO student = service.findByName(name);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        Optional<Student> savedStudent = service.addStudent(student);
        if (savedStudent.isPresent()) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("The course with that name already exists", HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping("/update")
    public ResponseEntity<String> updateByName(@RequestParam Long id, @RequestParam String name){
        if(service.updateStudent(id, name)){
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>("Fail update", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteByName(@RequestParam String name){
        if(service.deleteStudentByName(name)){
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to delete", HttpStatus.NOT_FOUND);
    }
}
