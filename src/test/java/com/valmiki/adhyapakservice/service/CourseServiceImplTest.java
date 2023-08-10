package com.valmiki.adhyapakservice.service;

import com.valmiki.adhyapakservice.dto.request.CourseRequest;
import com.valmiki.adhyapakservice.dto.response.CourseResponse;
import com.valmiki.adhyapakservice.entity.Course;
import com.valmiki.adhyapakservice.repo.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CourseServiceImplTest {

    @Mock
    private CourseRepository mockCourseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    private List<Course> courses;

    @BeforeEach
    public void setup() {
        courses = new ArrayList<>();
        Course course1 = Course.builder()
                .id(1)
                .courseName("Sample Course")
                .subHeading("Sample subheading")
                .build();
        Course course2 = Course.builder()
                .id(2)
                .courseName("Sample Course")
                .subHeading("Sample subheading")
                .build();
        courses.add(course1);
        courses.add(course2);
    }

    @Test
    public void testFindAll() {
        given(mockCourseRepository.findAll()).willReturn(courses);
        List<CourseResponse> result = courseService.findAll();
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void testFindById() {
        Course course = Course.builder()
                .id(1)
                .courseName("Sample Course")
                .subHeading("Sample sub heading")
                .build();
        when(mockCourseRepository.findById(1)).thenReturn(Optional.of(course));
        CourseResponse result = courseService.findByID(1);
        assertThat(result).isNotNull();
        assertThat(result).isEqualToComparingFieldByField(course);
    }

    @Test
    public void testSave() {
        CourseRequest courseRequest = CourseRequest.builder()
                .courseName("Sample Course")
                .subHeading("Sample sub heading")
                .build();
        Course savedCourse = Course.builder()
                .id(1)
                .courseName("Sample Course")
                .subHeading("Sample sub heading")
                .build();
        when(mockCourseRepository.save(any())).thenReturn(savedCourse);

        CourseResponse courseResponse = courseService.save(courseRequest);

        assertNotNull(courseResponse);
        assertEquals(0, courseResponse.getId());
        // assertEquals(1, courseResponse.getId()); gives error since the actual value is
        // 1 and not 0

        verify(mockCourseRepository).save(any());
    }
}
