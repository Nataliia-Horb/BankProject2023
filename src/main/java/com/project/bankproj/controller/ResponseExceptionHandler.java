package com.project.bankproj.controller;

import com.project.bankproj.dto.ErrorResponse;
import com.project.bankproj.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex) {
        ErrorResponse body = new ErrorResponse(ex.getMessage(), ErrorCode.PRODUCT_NOT_FOUND);
        return new ResponseEntity<>(body, NOT_FOUND);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException(AccountNotFoundException ex) {
        ErrorResponse body = new ErrorResponse(ex.getMessage(), ErrorCode.ACCOUNT_NOT_FOUND);
        return new ResponseEntity<>(body, NOT_FOUND);
    }

    @ExceptionHandler({AgreementNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleAgreementNotFoundException(AgreementNotFoundException ex) {
        ErrorResponse body = new ErrorResponse(ex.getMessage(), ErrorCode.AGREEMENT_NOT_FOUND);
        return new ResponseEntity<>(body, NOT_FOUND);
    }
}