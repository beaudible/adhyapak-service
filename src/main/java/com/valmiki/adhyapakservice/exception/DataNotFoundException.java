package com.valmiki.adhyapakservice.exception;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends Exception {
    //TODO: make custom exception
    private ErrorResponse errorResponse;

    public DataNotFoundException() {
        super("Data not found");
        this.errorResponse = new ErrorResponse();
        this.errorResponse.setCode(HttpStatus.NOT_FOUND.value());
        this.errorResponse.setMessage("Data not found");
    }
}
