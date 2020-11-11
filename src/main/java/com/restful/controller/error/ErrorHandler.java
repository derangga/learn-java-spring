package com.restful.controller.error;

import com.restful.data.response.WebResponse;
import com.restful.exception.UserExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = ConstraintViolationException.class)
    ResponseEntity<?> validationException(ConstraintViolationException constraintViolationException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new WebResponse<>(LocalDateTime.now().toString(), constraintViolationException.getMessage(), null));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<?> validationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new WebResponse<>(LocalDateTime.now().toString(), methodArgumentNotValidException.getMessage(), null));
    }

    @ExceptionHandler(value = UserExistsException.class)
    ResponseEntity<?> usernameNotFoundException(UserExistsException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new WebResponse<>(LocalDateTime.now().toString(), exception.getMessage(), null));
    }
}
