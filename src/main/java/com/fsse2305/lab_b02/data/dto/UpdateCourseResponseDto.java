package com.fsse2305.lab_b02.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UpdateCourseResponseDto {
    @JsonProperty("course_id")
    private String courseId;
    @JsonProperty("course name")
    private String name;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("teacher")
    private PersonDetailResponseDto teacher;
    @JsonProperty("students")
    private List<PersonDetailResponseDto> students;

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public PersonDetailResponseDto getTeacher() {
        return teacher;
    }

    public List<PersonDetailResponseDto> getStudents() {
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

    public void setTeacher(PersonDetailResponseDto teacher) {
        this.teacher = teacher;
    }

    public void setStudents(List<PersonDetailResponseDto> students) {
        this.students = students;
    }
}
