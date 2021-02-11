package com.krystiankownacki.homebudget.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class HomeBudgetControllerExceptionHandlerTest {

    @InjectMocks
    private HomeBudgetControllerExceptionHandler homeBudgetControllerExceptionHandler;

    @Test
    void handleRegisterNotFoundException() {
        ResponseEntity<Object> actual = homeBudgetControllerExceptionHandler.handleRegisterNotFoundException();

        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void handleInsufficientBalanceException() {
        ResponseEntity<Object> actual = homeBudgetControllerExceptionHandler.handleInsufficientBalanceException();

        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
    }
}