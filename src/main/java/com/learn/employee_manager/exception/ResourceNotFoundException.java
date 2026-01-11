package com.learn.employee_manager.exception;


// Extending RuntimeException means we don't have to add "throws" to every method signature
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
