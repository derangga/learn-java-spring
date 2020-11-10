package com.restful.controller.error;

import com.restful.data.response.MessageResponse;
import com.restful.exception.UserExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = ConstraintViolationException.class)
    ResponseEntity<?> validationException(ConstraintViolationException constraintViolationException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse(constraintViolationException.getMessage()));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<?> validationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse(methodArgumentNotValidException.getMessage()));
    }

    @ExceptionHandler(value = UserExistsException.class)
    ResponseEntity<?> usernameNotFoundException(UserExistsException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse(exception.getMessage()));
    }
}
