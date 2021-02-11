package com.krystiankownacki.homebudget.rest;

import com.krystiankownacki.homebudget.domain.exception.RegisterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HomeBudgetControllerExceptionHandler {

    @ExceptionHandler(RegisterNotFoundException.class)
    public ResponseEntity<Object> handleRegisterNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
