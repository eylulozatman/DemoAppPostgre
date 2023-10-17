package com.example.demoapp.service;

import com.example.demoapp.DAO.StudentDAO;
import com.example.demoapp.entity.Student;
import com.example.demoapp.repo.StudentRepo;
import com.example.demoapp.requests.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    StudentRepo studentRepo;

    public String saveStudent(StudentRequest studentRequest) {
        /*if(studentRequest!=null)
        {
            studentDAO.saveStudent(studentRequest);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return null;
        */
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setSchoolName(studentRequest.getSchoolName());
        studentRepo.save(student);
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        return response.getStatusCode() + "student succesfully added";
    }

    public ResponseEntity<String> deleteStudent(int id) {

        Student student = studentRepo.findById(id);
        studentRepo.delete(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
