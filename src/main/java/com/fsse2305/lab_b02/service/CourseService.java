package com.fsse2305.lab_b02.service;

import com.fsse2305.lab_b02.data.CourseDetailData;
import com.fsse2305.lab_b02.data.CreateCourseData;
import com.fsse2305.lab_b02.data.PersonDetailData;
import com.fsse2305.lab_b02.data.entity.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final PersonService personService;
    @Autowired
    public CourseService (PersonService personService) {
        this.personService = personService;
    }

    public CourseDetailData courseDetailData (CreateCourseData createCourseData){
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseId(createCourseData.getCourseld());
        courseEntity.setName(createCourseData.getName());
        courseEntity.setPrice(createCourseData.getPrice());
        courseEntity.setTeacher(personService.getCourseTeacher(createCourseData.getTeacherHkid()));

        PersonDetailData teacher = new PersonDetailData(personService.getCourseTeacher(createCourseData.getTeacherHkid()));
        CourseDetailData courseDetailData = new CourseDetailData();
        courseDetailData.setCourseId(courseEntity.getCourseId());
        courseDetailData.setName(courseEntity.getName());
        courseDetailData.setPrice(courseEntity.getPrice());
        courseDetailData.setTeacher(teacher);

        return courseDetailData;

    }
}
