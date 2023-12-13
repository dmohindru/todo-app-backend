package dev.dmohindru.todoappbackend.controller.v1;

import dev.dmohindru.todoappbackend.dto.TodoDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static dev.dmohindru.todoappbackend.controller.v1.ControllerUtils.getUserDTO;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/{todoListId}")
    public ResponseEntity<TodoDTO> createTodo(@PathVariable("todoListId") UUID todoListId,
                                              @RequestBody TodoDTO todoDTO,
                                              @RequestHeader Map<String, String> headers) {
        UserDTO userDTO = getUserDTO(headers);

        TodoDTO todo = todoService.createTodo(userDTO, todoListId, todoDTO);

        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @PatchMapping("/{todoTitleId}")
    public ResponseEntity<TodoDTO> updateTodo(@PathVariable("todoTitleId") UUID todoTitleId,
                                              @RequestBody TodoDTO todoDTO,
                                              @RequestHeader Map<String, String> headers) {
        return null;
    }
}
