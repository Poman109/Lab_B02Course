package com.fsse2305.lab_b02.data;

import com.fsse2305.lab_b02.data.entity.CourseEntity;

import java.util.List;

public class GotAllCourseData {
    private String courseId;
    private String name;
    private Double price;
    private PersonDetailData teacher;
    private List<PersonDetailData> students;



    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public PersonDetailData getTeacher() {
        return teacher;
    }

    public List<PersonDetailData> getStudents() {
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

    public void setTeacher(PersonDetailData teacher) {
        this.teacher = teacher;
    }

    public void setStudents(List<PersonDetailData> students) {
        this.students = students;
    }
}
