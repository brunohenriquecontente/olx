package br.com.brunocontentedev.auth.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BadCredentialsException extends RuntimeException {

    private final Issue issue;

    private BadCredentialsException(Issue issue) {
        super(issue.message());
        this.issue = issue;
    }

    public static BadCredentialsException from(String message) {
        return new BadCredentialsException(new Issue(message, HttpStatus.UNAUTHORIZED.value()));
    }
}
