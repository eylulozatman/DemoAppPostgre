package com.example.demoapp.DAO;


import com.example.demoapp.requests.StudentRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public ResponseEntity<Void> saveStudent(StudentRequest studentRequest) {
        try {
            String insertSql = "INSERT INTO student (name, age, school_name) VALUES (?, ?, ?)";
            Query query = entityManager.createNativeQuery(insertSql);

            query.setParameter(1, studentRequest.getName());
            query.setParameter(2, studentRequest.getAge());
            query.setParameter(3, studentRequest.getSchoolName());

            int rowsAffected = query.executeUpdate();
            if (rowsAffected == 1) {
                // Commit the transaction if the INSERT was successful
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                // Rollback the transaction if the INSERT failed
                entityManager.getTransaction().rollback();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            // Rollback the transaction in case of an exception
            entityManager.getTransaction().rollback();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

