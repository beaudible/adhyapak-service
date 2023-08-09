package com.valmiki.adhyapakservice.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@JsonIgnoreProperties (ignoreUnknown = true)
public class CourseRequest {

    private int id;
    @JsonProperty("courseName")
    @NotBlank(message = "Course Name can not be blank")
    private String courseName;

    @NotBlank(message = "Sub heading can not be blank")
    private String subHeading;
}
