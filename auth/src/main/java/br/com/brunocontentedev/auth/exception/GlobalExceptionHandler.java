package br.com.brunocontentedev.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Issue handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return new Issue(e.getMessage(), HttpStatus.CONFLICT.value());
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Issue handleBadCredentialsException(BadCredentialsException e) {
        return new Issue(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Issue handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new Issue(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Issue handleRuntimeException(RuntimeException e) {
        return new Issue(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
}
