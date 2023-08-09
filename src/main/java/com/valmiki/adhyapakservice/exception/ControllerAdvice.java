package com.valmiki.adhyapakservice.exception;


import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class ControllerAdvice {

    @ExceptionHandler({DataNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(ex.getMessage());
        log.error("data not found exception occured: {}", ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler({RuntimeException.class})
//    public ResponseEntity<ErrorResponse> globalExceptionHandler(RuntimeException ex) {
//       ErrorResponse errorResponse = new ErrorResponse();
//       errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//       errorResponse.setMessage(ex.getMessage());
//       return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    //TODO: 404 for data not found


}
