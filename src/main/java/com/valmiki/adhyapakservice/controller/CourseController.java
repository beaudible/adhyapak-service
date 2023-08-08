package com.valmiki.adhyapakservice.controller;
import com.valmiki.adhyapakservice.entity.Courses;
import com.valmiki.adhyapakservice.service.CourseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService theCourseService) {
        courseService = theCourseService;
    }

    @GetMapping
    public List<Courses> listCourses() {
        return courseService.findAll();
    }

    @PostMapping
    public Courses addCourse(@RequestBody Courses theCourse) {
        courseService.save(theCourse);
        return theCourse;
    }


    @GetMapping("/{id}")
    public Courses getCourseById(@PathVariable int id) {
        return courseService.findByID(id);
    }
}
