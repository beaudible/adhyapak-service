package com.valmiki.adhyapakservice.controller;

import com.valmiki.adhyapakservice.dto.request.CourseRequest;
import com.valmiki.adhyapakservice.dto.response.CourseResponse;
import com.valmiki.adhyapakservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseResponse>> listCourses() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @PostMapping
    public ResponseEntity<CourseResponse> addCourse(@RequestBody CourseRequest courseRequest) {
        return ResponseEntity.ok(courseService.save(courseRequest));
    }


    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable int id) {
        return ResponseEntity.ok(courseService.findByID(id));
    }
}
