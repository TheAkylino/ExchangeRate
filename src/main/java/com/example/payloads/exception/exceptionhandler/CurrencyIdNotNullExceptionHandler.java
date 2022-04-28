package com.example.payloads.exception.exceptionhandler;

import com.example.payloads.exception.CurrencyIdNotNullException;
import com.example.payloads.exception.generic.GenericExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CurrencyIdNotNullExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CurrencyIdNotNullException.class)
    public final ResponseEntity<Object> configExceptionHandler(CurrencyIdNotNullException ex, WebRequest request) {
        return new ResponseEntity(new GenericExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false)), HttpStatus.NOT_FOUND);
    }
}
