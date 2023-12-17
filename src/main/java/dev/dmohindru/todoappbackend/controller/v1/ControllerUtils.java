package dev.dmohindru.todoappbackend.controller.v1;

import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.exception.MissingHeaderException;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

import static dev.dmohindru.todoappbackend.constants.RequestHeaderKey.NAME;
import static dev.dmohindru.todoappbackend.constants.RequestHeaderKey.USER_NAME;

public class ControllerUtils {
    public static UserDTO getUserDTO(Map<String, String> requestHeader) {
        String username = requestHeader.get(USER_NAME.getKeyName());
        if (username == null) {
            throw new MissingHeaderException("Username header missing");
        }

        String name = requestHeader.get(NAME.getKeyName());
        if (name == null) {
            throw new MissingHeaderException("Name header missing");
        }

        return UserDTO
                .builder()
                .username(username)
                .name(name)
                .build();
    }

    public static UserDTO getUserDTO(HttpServletRequest request) {
        String username = request.getHeader(USER_NAME.getKeyName());
        if (username == null) {
            throw new MissingHeaderException("Username header missing");
        }

        String name = request.getHeader(NAME.getKeyName());
        if (name == null) {
            throw new MissingHeaderException("Name header missing");
        }

        return UserDTO
                .builder()
                .username(username)
                .name(name)
                .build();

    }
}
