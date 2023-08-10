package com.valmiki.adhyapakservice.controller;

import com.valmiki.adhyapakservice.dto.request.CourseRequest;
import com.valmiki.adhyapakservice.dto.response.CourseResponse;
import com.valmiki.adhyapakservice.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CourseControllerTest {

    @Mock
    private CourseService mockCourseService;

    @InjectMocks
    private CourseController courseController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListCourses() {
        List<CourseResponse> courseResponses = new ArrayList<>();
        when(mockCourseService.findAll()).thenReturn(courseResponses);
        ResponseEntity<List<CourseResponse>> response = courseController.listCourses();
        assertThat(response.getBody()).isEqualTo(courseResponses);
    }

    @Test
    public void testGetCourseById() {
        CourseResponse courseResponse = new CourseResponse();
        when(mockCourseService.findByID(1)).thenReturn(courseResponse);
        ResponseEntity<CourseResponse> responseEntity = courseController.getCourseById(1);
        assertThat(responseEntity.getBody()).isEqualTo(courseResponse);
    }

    @Test
    public void testAddCourse() {
        CourseRequest courseRequest = new CourseRequest();
        CourseResponse courseResponse = new CourseResponse();
        when(mockCourseService.save(courseRequest)).thenReturn(courseResponse);
        ResponseEntity<CourseResponse> responseEntity = courseController.addCourse(courseRequest);
        assertThat(responseEntity.getBody()).isEqualTo(courseResponse);
    }


}
