package com.valmiki.adhyapakservice.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CourseRequest {

    private int id;

    private String courseName;

    private String subHeading;
}
