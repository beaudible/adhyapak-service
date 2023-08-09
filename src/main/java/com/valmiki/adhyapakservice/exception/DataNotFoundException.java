package com.valmiki.adhyapakservice.exception;

public class DataNotFoundException extends RuntimeException {
    //TODO: make custom exception

    private static final String ERROR_MESSAGE = "Data not found";

    public DataNotFoundException() {
        super(ERROR_MESSAGE);
    }
}
