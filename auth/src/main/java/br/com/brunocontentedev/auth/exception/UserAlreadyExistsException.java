package br.com.brunocontentedev.auth.exception;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(Issue issue) {
        super(issue.message());
    }

    public static UserAlreadyExistsException alreadyExists(String message) {
        return new UserAlreadyExistsException(new Issue(message, 409));
    }
}
