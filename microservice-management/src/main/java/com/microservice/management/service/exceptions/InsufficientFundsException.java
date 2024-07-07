package com.microservice.management.service.exceptions;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException() {
        super("Saldo no disponible");
    }
}
