package com.fsse2305.lab_b02.api;

import com.fsse2305.lab_b02.data.CourseDetailData;
import com.fsse2305.lab_b02.data.CreateCourseData;
import com.fsse2305.lab_b02.data.GotAllCourseData;
import com.fsse2305.lab_b02.data.dto.CourseDetailResponseDto;
import com.fsse2305.lab_b02.data.dto.CreateCourseRequestDto;
import com.fsse2305.lab_b02.data.dto.GotAllCourseDataResponseDto;
import com.fsse2305.lab_b02.data.dto.PersonDetailResponseDto;
import com.fsse2305.lab_b02.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseApi {

    private final CourseService courseService;
    @Autowired
    public CourseApi(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/course")
    public CourseDetailResponseDto createCourse(@RequestBody CreateCourseRequestDto createCourseRequestDto){
        CreateCourseData createCourseData = new CreateCourseData(createCourseRequestDto);
        CourseDetailData data = courseService.courseDetailData(createCourseData);
        CourseDetailResponseDto courseDetailResponseDto = new CourseDetailResponseDto();
        PersonDetailResponseDto teacher = new PersonDetailResponseDto(data.getTeacher());

        courseDetailResponseDto.setCourseId(data.getCourseId());
        courseDetailResponseDto.setName(data.getName());
        courseDetailResponseDto.setPrice(data.getPrice());
        courseDetailResponseDto.setTeacher(teacher);

        return courseDetailResponseDto;


    }

    @GetMapping("/course")
    public List<GotAllCourseDataResponseDto> gotAllCourseList(){
       List<GotAllCourseData> gotAllCourseDataArray = courseService.gotAllCourseData();

       List<GotAllCourseDataResponseDto> gotAllCourseDataResponseDtoArray = new ArrayList<>();
       for(GotAllCourseData gotAllCourseData: gotAllCourseDataArray){
           GotAllCourseDataResponseDto gotAllCourseDataResponseDto = new GotAllCourseDataResponseDto(gotAllCourseData);
           gotAllCourseDataResponseDtoArray.add(gotAllCourseDataResponseDto);
       }
       return gotAllCourseDataResponseDtoArray;
    }





}
