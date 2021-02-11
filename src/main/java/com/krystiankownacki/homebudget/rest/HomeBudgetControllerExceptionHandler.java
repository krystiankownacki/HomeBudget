package com.krystiankownacki.homebudget.rest;

import com.krystiankownacki.homebudget.domain.exception.InsufficientBalanceException;
import com.krystiankownacki.homebudget.domain.exception.RegisterNotFoundException;
import com.krystiankownacki.homebudget.domain.exception.SelfTransferException;
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

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<Object> handleInsufficientBalanceException() {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @ExceptionHandler(SelfTransferException.class)
    public ResponseEntity<Object> handleSelfTransferException() {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
