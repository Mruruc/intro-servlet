package com.mruruc.exceptions;

public class UserRegistrationValidationException extends RuntimeException {
    public UserRegistrationValidationException(String message){
        super(message);
    }
}
