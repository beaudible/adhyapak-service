package com.valmiki.adhyapakservice.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CourseResponse {
    private int id;

    private String courseName;

    private String subHeading;
}
