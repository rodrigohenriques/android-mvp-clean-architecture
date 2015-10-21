package com.github.rodrigohenriques.mvp.sample.domain.exception;

public class DomainError {
    String code;
    String message;
    Exception exception;

    public DomainError(String code, String message, Exception exception) {
        this.code = code;
        this.message = message;
        this.exception = exception;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Exception getException() {
        return exception;
    }
}
