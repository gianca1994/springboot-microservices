package com.gianca1994.bicyclemicroservice.exception;

public class Conflict extends Exception {
    public Conflict(String message) {
        super(message);
    }

    public Conflict(String message, Throwable cause) {
        super(message, cause);
    }
}
