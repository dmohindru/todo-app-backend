package dev.dmohindru.todoappbackend.exception;

public class MissingRecordException extends RuntimeException {
    public MissingRecordException(String message) {
        super(message);
    }
}
