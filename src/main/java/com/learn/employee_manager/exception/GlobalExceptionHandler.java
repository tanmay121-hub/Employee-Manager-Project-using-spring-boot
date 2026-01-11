package com.learn.employee_manager.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice    //  "Watch all Controllers for errors"
public class GlobalExceptionHandler {

    // "If a ResourceNotFoundException happens anywhere, run this method"
    @ExceptionHandler
    public ResponseEntity<String> handleResourceNotFound (ResourceNotFoundException ex){
        // Return the error message and HTTP 404 status
        return  new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
