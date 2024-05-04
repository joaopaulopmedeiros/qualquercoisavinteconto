package com.github.qualquercoisavinteconto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.github.qualquercoisavinteconto.factories.BadRequestFactory;
import com.github.qualquercoisavinteconto.responses.ValidationFailedResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ValidationFailedResponse> handleResourceNotFoundException(UserAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(BadRequestFactory.createValidationFailedResponse("E001", ex.getMessage()));
    }
}
