package com.project.bankproj.exception;

public class AgreementNotFoundException extends RuntimeException {
    public AgreementNotFoundException(String message) {
        super(message);
    }
}