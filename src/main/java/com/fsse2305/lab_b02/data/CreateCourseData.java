package com.fsse2305.lab_b02.data;

import com.fsse2305.lab_b02.data.dto.CreateCourseRequestDto;

public class CreateCourseData {
    private String courseld;
    private String name;
    private Double price;
    private String teacherHkid;

    public CreateCourseData(CreateCourseRequestDto data){
        this.courseld = data.getCourseId();
        this.name = data.getName();
        this.price = data.getPrice();
        this.teacherHkid = data.getTeacherHkid();
    }

    public String getCourseld() {
        return courseld;
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

    public void setCourseld(String courseld) {
        this.courseld = courseld;
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
