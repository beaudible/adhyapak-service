package com.valmiki.adhyapakservice.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Entity
@Builder
@Data
@ToString
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "subheading")
    private String subHeading;

    public Course() {

    }

    public Course(int id, String courseName, String subHeading) {
        this.id = id;
        this.courseName = courseName;
        this.subHeading = subHeading;
    }

}


