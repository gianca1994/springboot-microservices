package com.gianca1994.carmicroservice.exception;

public class Conflict extends Exception {
    public Conflict(String message) {
        super(message);
    }

    public Conflict(String message, Throwable cause) {
        super(message, cause);
    }
}
