package dev.dmohindru.todoappbackend.controller.v1;

import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static dev.dmohindru.todoappbackend.controller.v1.ControllerUtils.getUserDTO;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<UserDTO> getUserTodos(HttpServletRequest request) {

        UserDTO userDTO = getUserDTO(request);

        UserDTO userTodoList = userService.getUserTodoList(userDTO);

        return ResponseEntity.ok(userTodoList);
    }
}
