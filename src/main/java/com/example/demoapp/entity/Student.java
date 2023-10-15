package com.example.demoapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table
@Data
public class Student {
    @Id
    @GeneratedValue
    int id;
    String name;
    int age;
    String schoolName;
}
