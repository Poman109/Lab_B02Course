package com.fsse2305.lab_b02.data.entity;

import java.util.List;

public class CourseEntity {
    private String courseId;
    private String name;
    private Double price;
    private PersonEntity teacher;
    List<PersonEntity> students;

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public PersonEntity getTeacher() {
        return teacher;
    }

    public List<PersonEntity> getStudents() {
        return students;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTeacher(PersonEntity teacher) {
        this.teacher = teacher;
    }

    public void setStudents(List<PersonEntity> students) {
        this.students = students;
    }
}
