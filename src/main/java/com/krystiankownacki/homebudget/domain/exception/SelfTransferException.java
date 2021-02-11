package com.krystiankownacki.homebudget.domain.exception;

public class SelfTransferException extends RuntimeException {

    public SelfTransferException() {
        super("Transferring to same register is not allowed");
    }
}
