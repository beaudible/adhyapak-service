package com.valmiki.adhyapakservice.repo;


import com.valmiki.adhyapakservice.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public final class CourseRepositoryTest {



    @Mock
    private CourseRepository mockCourseRepository;

    @Test
    public void testFindById() {
        Course course = Course.builder()
                .id(1)
                .courseName("Sample Course")
                .subHeading("Sample sub heading")
                .build();
        when(mockCourseRepository.findById(1)).thenReturn(Optional.of(course));

        Optional<Course> result = mockCourseRepository.findById(1);

        assertTrue(result.isPresent());


        verify(mockCourseRepository).findById(1);
    }


    @Test
    public void testFindAll() {

        List<Course> courses = new ArrayList<>();
        courses.add(Course.builder()
                .id(1)
                .courseName("Course 1")
                .subHeading("Sample sub heading")
                .build());
        courses.add(Course.builder()
                .id(2)
                .courseName("Course 2")
                .subHeading("Sample sub heading")
                .build());
        when(mockCourseRepository.findAll()).thenReturn(courses);

        List<Course> result = mockCourseRepository.findAll();

        assertEquals(2, result.size());

        verify(mockCourseRepository).findAll();
    }

    @Test
    public void testSave() {
        Course course = Course.builder()
                .id(1)
                .courseName("Sample Course")
                .subHeading("Sample sub heading")
                .build();
        when(mockCourseRepository.save(course)).thenReturn(course);

        Course savedCourse = mockCourseRepository.save(course);

        assertNotNull(savedCourse);
        assertEquals(1, savedCourse.getId());

        verify(mockCourseRepository).save(course);
    }


}
