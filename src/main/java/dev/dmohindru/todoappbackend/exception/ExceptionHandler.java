package dev.dmohindru.todoappbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
            (value = {
                    MissingRecordException.class,
                    MissingIdException.class,
                    MissingRecordException.class,
                    UnauthorizedException.class,
                    UserNotFoundException.class
            })
    public ResponseEntity<String> handleUnauthorisedRequest(RuntimeException ex, WebRequest webRequest) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

    }
}
