package dev.dmohindru.todoappbackend.exception;

public class MissingHeaderException extends RuntimeException{

    public MissingHeaderException(String message){
        super(message);
    }
}
