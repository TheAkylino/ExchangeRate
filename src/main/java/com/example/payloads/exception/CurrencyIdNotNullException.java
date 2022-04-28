package com.example.payloads.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CurrencyIdNotNullException  extends RuntimeException {

    public CurrencyIdNotNullException(String message) {
        super(message);
    }
}
