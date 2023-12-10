package dev.dmohindru.todoappbackend.controller.v1;

import dev.dmohindru.todoappbackend.constants.RequestHeaderKey;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.exception.MissingHeaderException;
import dev.dmohindru.todoappbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static dev.dmohindru.todoappbackend.constants.RequestHeaderKey.NAME;
import static dev.dmohindru.todoappbackend.constants.RequestHeaderKey.USER_NAME;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<UserDTO> getUserTodos(@RequestHeader Map<String, String> headers) {
        String username = headers.get(USER_NAME.getKeyName());
        if (username == null) {
            throw new MissingHeaderException("Username header missing");
        }

        String name = headers.get(NAME.getKeyName());
        if (name == null) {
            throw new MissingHeaderException("Name header missing");
        }
        UserDTO userDTO = UserDTO
                .builder()
                .username(username)
                .name(name)
                .build();

        UserDTO userTodoList = userService.getUserTodoList(userDTO);

        return ResponseEntity.ok(userTodoList);
    }
}
