package com.example.exceptions.exceptionhandler;

import com.example.exceptions.generic.GenericExceptionResponse;
import com.example.exceptions.CurrencyNotFoundException;
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
public class CurrencyNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CurrencyNotFoundException.class)
    public final ResponseEntity<Object> configExceptionHandler(CurrencyNotFoundException ex, WebRequest request) {
        return new ResponseEntity(new GenericExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false)), HttpStatus.NOT_FOUND);
    }
}
