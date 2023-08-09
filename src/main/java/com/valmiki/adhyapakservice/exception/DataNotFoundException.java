package com.valmiki.adhyapakservice.exception;

public class DataNotFoundException extends RuntimeException {
    //TODO: make custom exception

    public DataNotFoundException() {
        super("Data not found");
    }
}
