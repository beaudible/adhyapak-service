package com.valmiki.adhyapakservice.service;

import com.valmiki.adhyapakservice.entity.Courses;

import java.util.List;

public interface CourseService {
    List<Courses> findAll();

    Courses findByID(int theId);

    void save(Courses theCourse);
}
