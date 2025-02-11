package br.com.brunocontentedev.catalog.exception;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(Issue issue) {
        super(issue.message());
    }

    public static ProductNotFoundException notFound(String message) {
        return new ProductNotFoundException(new Issue(message, 409));
    }
}
