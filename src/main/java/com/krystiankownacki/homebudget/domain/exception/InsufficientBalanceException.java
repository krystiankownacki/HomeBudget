package com.krystiankownacki.homebudget.domain.exception;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String registerName) {
        super(String.format("Registry with name: %s has not enough balance", registerName));
    }
}
