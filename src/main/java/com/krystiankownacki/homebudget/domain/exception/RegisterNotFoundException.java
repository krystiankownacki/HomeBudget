package com.krystiankownacki.homebudget.domain.exception;

public class RegisterNotFoundException extends RuntimeException {

    public RegisterNotFoundException(String name) {
        super(String.format("Registry with name: %s not found", name));
    }
}
