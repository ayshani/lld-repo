package org.cache.exception;

public class NotFoundException extends Exception{

    String message;
    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
