package com.valmiki.adhyapakservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "subheading")
    private String subHeading;

    public Courses() {

    }

    public Courses(int id, String courseName, String subHeading) {
        this.id = id;
        this.courseName = courseName;
        this.subHeading = subHeading;
    }

    public Courses(String courseName, String subHeading) {
        this.courseName = courseName;
        this.subHeading = subHeading;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    @Override
    public String toString() {
        return "Courses{"
                +
                "id="
                + id
                +
                ", courseName='"
                + courseName + '\''
                +
                ", subHeading='"
                + subHeading
                + '\''
                +
                '}';
    }
}


