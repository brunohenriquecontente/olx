package br.com.brunocontentedev.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Objects;


@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Issue handleProductNotFoundException(ProductNotFoundException e) {
        return new Issue(e.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Issue handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new Issue(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage(), HttpStatus.BAD_REQUEST.value());
    }


    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Issue handleNoResourceFoundException(NoResourceFoundException e) {
        return new Issue(e.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Issue handleException(Exception e) {
        return new Issue(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
