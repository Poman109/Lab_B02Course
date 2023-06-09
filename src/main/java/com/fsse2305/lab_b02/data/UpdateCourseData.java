package com.fsse2305.lab_b02.data;

public class UpdateCourseData {
    private String courseld;
    private String name;
    private Double price;
    private String teacherHkid;

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
