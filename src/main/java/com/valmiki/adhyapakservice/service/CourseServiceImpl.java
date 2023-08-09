package com.valmiki.adhyapakservice.service;

import com.valmiki.adhyapakservice.dto.request.CourseRequest;
import com.valmiki.adhyapakservice.dto.response.CourseResponse;
import com.valmiki.adhyapakservice.entity.Course;
import com.valmiki.adhyapakservice.exception.DataNotFoundException;
import com.valmiki.adhyapakservice.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseResponse> findAll() {
        List<Course> courseList = courseRepository.findAll();
        // TODO: Remove below code and use mapstruct for mapping
        // TODO: And also use records for dtos
        return courseList.stream()
                .map(e -> CourseResponse.builder()
                        .id(e.getId())
                        .courseName(e.getCourseName())
                        .subHeading(e.getSubHeading())
                        .build()).toList();
    }

    @Override
    public List<CourseResponse> findByID(int theId) {
        Optional<Course> result = courseRepository.findById(theId);
        Course theCourse;
        if (result.isPresent()) {
            theCourse = result.get();
        } else {
            try {
                throw new DataNotFoundException();
            } catch (DataNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return Collections.singletonList(
                CourseResponse.builder()
                        .id(theCourse.getId())
                        .courseName(theCourse.getCourseName())
                        .subHeading(theCourse.getSubHeading())
                        .build()
        );
    }

    @Override
    public CourseResponse save(CourseRequest courseRequest) {
        Course course = Course.builder()
                        .courseName(courseRequest.getCourseName())
                        .subHeading(courseRequest.getSubHeading())
                                .build();
        courseRepository.save(course);
        return CourseResponse.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .subHeading(course.getSubHeading())
                .build();
    }
}
