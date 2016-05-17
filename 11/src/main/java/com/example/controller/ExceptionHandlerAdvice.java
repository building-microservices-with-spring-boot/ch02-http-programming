package com.example.controller;

import com.example.exception.ValidationException;
import com.example.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class ExceptionHandlerAdvice {
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity validationExceptionHandler(Exception e) {
        ErrorMessage error = new ErrorMessage("Validation Failed", e.getMessage());
        return new ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}