package com.valmiki.adhyapakservice.service;

import com.valmiki.adhyapakservice.dao.CoursesRepository;
import com.valmiki.adhyapakservice.entity.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesServiceImpl implements CourseService {

   private CoursesRepository coursesRepository;

   @Autowired
   public CoursesServiceImpl(CoursesRepository theCoursesRepository) {
       coursesRepository = theCoursesRepository;
   }
    @Override
    public List<Courses> findAll() {
        return coursesRepository.findAll();
    }

    @Override
    public Courses findByID(int theId) {
        Optional<Courses> result = coursesRepository.findById(theId);
        Courses theCourses = null;
        if (result.isPresent()) {
            theCourses = result.get();
        } else {
            // we didn't find the course
            throw new RuntimeException("Did not find course id - " + theId);
        }

        return theCourses;
    }

    @Override
    public void save(Courses theCourse) {
        coursesRepository.save(theCourse);
    }
}
