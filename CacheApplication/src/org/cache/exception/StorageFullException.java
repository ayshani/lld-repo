package org.cache.exception;

public class StorageFullException extends Exception{
    String message;
    public StorageFullException(String message) {
        super(message);
        this.message = message;
    }
}
