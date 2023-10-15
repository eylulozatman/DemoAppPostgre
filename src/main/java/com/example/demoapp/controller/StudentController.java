package com.example.demoapp.controller;


import com.example.demoapp.entity.Student;
import com.example.demoapp.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {


    @Autowired
    StudentRepo stdrepo;

    @GetMapping("/student-name")
    public String getStudentName(@RequestParam(value = "id") int id) {
        Student student = stdrepo.findById(id);

        return student.getName();

    }

    @GetMapping("/all-student")
    public List<Student> getAllStudent() {
        return stdrepo.findAll();
    }

}
