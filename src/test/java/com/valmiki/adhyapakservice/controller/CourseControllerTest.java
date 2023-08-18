package com.valmiki.adhyapakservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.valmiki.adhyapakservice.dto.request.CourseRequest;
import com.valmiki.adhyapakservice.dto.response.CourseResponse;
import com.valmiki.adhyapakservice.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Autowired
    private ObjectMapper objectMapper;
    private CourseRequest courseRequest, courseRequest2;
    private CourseResponse courseResponse, courseResponse2;

    private List<CourseResponse> courseList;
    @BeforeEach
    void init() {


        courseList = new ArrayList<>();
        courseRequest = new CourseRequest();
        courseRequest.setCourseName("Sample Course");
        courseRequest.setSubHeading("Sample subheading");

        courseRequest2 = new CourseRequest();
        courseRequest2.setCourseName("Sample Course 2");
        courseRequest2.setSubHeading("Sample subheading 2");

        courseResponse = new CourseResponse();
        courseResponse.setCourseName(courseRequest.getCourseName());
        courseResponse.setSubHeading(courseRequest.getSubHeading());

        courseResponse2 = new CourseResponse();
        courseResponse2.setCourseName(courseRequest2.getCourseName());
        courseResponse2.setSubHeading(courseRequest2.getSubHeading());

        courseList.add(courseResponse);
        courseList.add(courseResponse2);
    }




    @Test
    void shouldCreateNewCourse() throws Exception {
        when(courseService.save(any(CourseRequest.class))).thenReturn(courseResponse);
        this.mockMvc.perform(post("/api/v1/course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(courseRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.courseName", is(courseRequest.getCourseName())))
                .andExpect(jsonPath("$.subHeading", is(courseRequest.getSubHeading())));
    }

    @Test
    void shouldFetchAllCourses() throws Exception {
        when(courseService.findAll()).thenReturn(courseList);

        this.mockMvc.perform(get("/api/v1/course"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(courseList.size())));
    }

    @Test
    void shouldFetchCoursesById() throws Exception {
        when(courseService.findByID(anyInt())).thenReturn(courseResponse);

        this.mockMvc.perform(get("/api/v1/course/{id}",Long.valueOf(1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.courseName", is(courseResponse.getCourseName())))
                .andExpect(jsonPath("$.subHeading", is(courseResponse.getSubHeading())));
    }
}
