package com.fsse2305.lab_b02.service;

import com.fsse2305.lab_b02.data.*;
import com.fsse2305.lab_b02.data.entity.CourseEntity;
import com.fsse2305.lab_b02.data.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private static List<CourseEntity> courseEntityList = new ArrayList<>();

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
        courseEntityList.add(courseEntity);

        PersonDetailData teacher = new PersonDetailData(personService.getCourseTeacher(createCourseData.getTeacherHkid()));
        CourseDetailData courseDetailData = new CourseDetailData();
        courseDetailData.setCourseId(courseEntity.getCourseId());
        courseDetailData.setName(courseEntity.getName());
        courseDetailData.setPrice(courseEntity.getPrice());
        courseDetailData.setTeacher(teacher);


        return courseDetailData;

    }

    public List<GotAllCourseData> gotAllCourseData(){
        List<GotAllCourseData> gotAllCourseDataArray = new ArrayList<>();
        for(CourseEntity courseEntity: courseEntityList){
            GotAllCourseData gotAllCourseData = new GotAllCourseData();
            gotAllCourseData.setCourseId(courseEntity.getCourseId());
            gotAllCourseData.setName(courseEntity.getName());
            gotAllCourseData.setPrice(courseEntity.getPrice());
            PersonDetailData teacher = new PersonDetailData(courseEntity.getTeacher());
            gotAllCourseData.setTeacher(teacher);

            gotAllCourseDataArray.add(gotAllCourseData);


        }
        return gotAllCourseDataArray;
    }

    public UpdatedCourseData updateCourse(UpdateCourseData updateCourseData){
        for(CourseEntity courseEntity:courseEntityList){
            if (courseEntity.getCourseId().equals(updateCourseData.getCourseld())){
                courseEntity.setCourseId(updateCourseData.getCourseld());
                courseEntity.setName(updateCourseData.getName());
                courseEntity.setPrice(updateCourseData.getPrice());
                courseEntity.setCourseId(updateCourseData.getCourseld());
                courseEntity.setTeacher(personService.getCourseTeacher(updateCourseData.getTeacherHkid()));

                UpdatedCourseData updatedCourseData = new UpdatedCourseData();
                updatedCourseData.setName(courseEntity.getName());
                updatedCourseData.setPrice(courseEntity.getPrice());
                updatedCourseData.setCourseId(courseEntity.getCourseId());
                PersonDetailData teacher = new PersonDetailData(courseEntity.getTeacher());
                updatedCourseData.setTeacher(teacher);
                return updatedCourseData;
            }
        }
        throw new NotFoundPeopleException();
    }

    public DeletedCourseByCourseIdData deleteCourse(String courseId){
        for (CourseEntity courseEntity: courseEntityList){
            if (courseEntity.getCourseId().equals(courseId)){
                courseEntityList.remove(courseEntity);
                DeletedCourseByCourseIdData deletedCourseByCourseIdData = new DeletedCourseByCourseIdData();
                deletedCourseByCourseIdData.setCourseId(courseEntity.getCourseId());
                deletedCourseByCourseIdData.setName(courseEntity.getName());
                deletedCourseByCourseIdData.setPrice(courseEntity.getPrice());
                PersonDetailData teacher = new PersonDetailData(courseEntity.getTeacher());
                deletedCourseByCourseIdData.setTeacher(teacher);

                return deletedCourseByCourseIdData;
            }

        }

        throw new NotFoundPeopleException();
    }

    public CourseDetailData createStudent(String courseId, String hkid){
        for(CourseEntity courseEntity: courseEntityList){
            if (courseEntity.getCourseId().equals(courseId)){
                CourseDetailData courseDetailData = new CourseDetailData();
                courseDetailData.setCourseId(courseEntity.getCourseId());
                courseDetailData.setName(courseEntity.getName());
                courseDetailData.setPrice(courseEntity.getPrice());
                PersonDetailData teacher = new PersonDetailData(courseEntity.getTeacher());
                courseDetailData.setTeacher(teacher);

                List<PersonEntity> studentsArray = personService.createCourseStudent(hkid);
                List<PersonDetailData> studentArray = new ArrayList<>();
                for(PersonEntity personEntity : studentsArray){
                    PersonDetailData personDetailData = new PersonDetailData(personEntity);
                    studentArray.add(personDetailData);
                }
                courseDetailData.setStudents(studentArray);

                return courseDetailData;
            }
        }

        throw new NotFoundPeopleException();
    }
}
