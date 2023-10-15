package com.example.demoapp.repo;


import com.example.demoapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Override
    List<Student> findAll();

    Student findById(int id);


}
