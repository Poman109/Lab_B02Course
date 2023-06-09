package com.fsse2305.lab_b02.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateCourseRequestDto {
    @JsonProperty("course_id")
    private String courseId;
    @JsonProperty("course name")
    private String name;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("teacher_hkid")
    private String teacherHkid;

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getTeacherHkid() {
        return teacherHkid;
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

    public void setTeacherHkid(String teacherHkid) {
        this.teacherHkid = teacherHkid;
    }
}
