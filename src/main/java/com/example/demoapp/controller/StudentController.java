package com.example.demoapp.controller;


import com.example.demoapp.entity.Student;
import com.example.demoapp.repo.StudentRepo;
import com.example.demoapp.requests.StudentRequest;
import com.example.demoapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StudentService studentService;

    @GetMapping("/student-name")
    public String getStudentName(@RequestParam(value = "id") int id) {

        Student student = studentRepo.findById(id);
        return student.getName();
    }

    @GetMapping("/all-students")
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @PostMapping("/save-student")
    public String saveNewStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.saveStudent(studentRequest);
    }

    @DeleteMapping("/delete-student")
    public ResponseEntity<String> deleteStudent(@RequestParam(value = "id") int id) {

        return studentService.deleteStudent(id);
    }


}
