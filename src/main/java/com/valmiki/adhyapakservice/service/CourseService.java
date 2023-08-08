package com.valmiki.adhyapakservice.service;

import com.valmiki.adhyapakservice.dto.request.CourseRequest;
import com.valmiki.adhyapakservice.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {
    List<CourseResponse> findAll();

    List<CourseResponse> findByID(int theId);

    void save(CourseRequest courseRequest);
}
