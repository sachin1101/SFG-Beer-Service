package com.example.sfgbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionsHandler {


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationHandler(ConstraintViolationException e)
    {
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach( constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + "----" + constraintViolation.getMessage());
            System.out.println(constraintViolation.getPropertyPath() + "----" + constraintViolation.getMessage() +"\n");
        });


        return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> handleBindExceptions(BindException bindException)
    {
        return new ResponseEntity(bindException.getAllErrors(), HttpStatus.BAD_REQUEST);

    }

}
