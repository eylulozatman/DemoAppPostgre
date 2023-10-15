package com.example.demoapp.controller;


import com.example.demoapp.entity.Student;
import com.example.demoapp.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/student-name")
    public String getStudentName(@RequestParam(value = "id") int id) {
        Student student = studentRepo.findById(id);

        return student.getName();

    }

    @GetMapping("/all-student")
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @PostMapping("/save-student")
    public ResponseEntity<Student> saveNewStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentRepo.save(student));
    }

}
