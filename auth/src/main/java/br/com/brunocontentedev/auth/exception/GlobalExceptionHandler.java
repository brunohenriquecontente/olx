package br.com.brunocontentedev.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Issue handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return new Issue(e.getMessage(), HttpStatus.CONFLICT.value());
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Issue handleRuntimeException(RuntimeException e) {
        return new Issue(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
}
