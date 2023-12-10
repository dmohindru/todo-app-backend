package dev.dmohindru.todoappbackend.exception;

public class MissingHeaderException extends RuntimeException{
    private String message;

    public MissingHeaderException(String message){
        super(message);
    }
}
