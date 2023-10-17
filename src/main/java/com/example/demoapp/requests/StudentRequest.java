package com.example.demoapp.requests;

public class StudentRequest {
    String name;
    int age;
    String schoolName;

    public StudentRequest(String name, int age, String schoolName) {
        this.name = name;
        this.age = age;
        if (schoolName == null) {
            this.schoolName = "undefined";
        } else {
            this.schoolName = "schoolName";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}



