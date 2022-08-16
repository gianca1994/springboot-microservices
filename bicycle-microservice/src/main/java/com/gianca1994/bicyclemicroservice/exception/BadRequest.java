package com.gianca1994.bicyclemicroservice.exception;

public class BadRequest extends RuntimeException {
    public BadRequest(String message) {
        super(message);
    }

    public BadRequest(String message, Throwable cause) {
        super(message, cause);
    }
}