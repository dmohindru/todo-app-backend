package dev.dmohindru.todoappbackend.controller.v1;

import dev.dmohindru.todoappbackend.dto.TodoDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.service.TodoService;
import jakarta.servlet.http.HttpServletRequest;
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
                                              HttpServletRequest request) {
        UserDTO userDTO = getUserDTO(request);

        TodoDTO todo = todoService.createTodo(userDTO, todoListId, todoDTO);

        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @PatchMapping("/{todoTitleId}")
    public ResponseEntity<TodoDTO> updateTodo(@PathVariable("todoTitleId") UUID todoTitleId,
                                              @RequestBody TodoDTO todoDTO,
                                              HttpServletRequest request) {

        UserDTO userDTO = getUserDTO(request);

        TodoDTO updatedTodo = todoService.updateTodo(userDTO, todoTitleId, todoDTO);
        return new ResponseEntity<>(updatedTodo, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{todoTitleId}/{todoId}")
    public ResponseEntity<TodoDTO> deleteTodo(@PathVariable("todoTitleId") UUID todoTitleId,
                                              @PathVariable("todoId") UUID todoId,
                                              HttpServletRequest request) {
        UserDTO userDTO = getUserDTO(request);
        TodoDTO deleteTodo = todoService.deleteTodo(userDTO, todoTitleId, todoId);

        return new ResponseEntity<>(deleteTodo, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable("todoId") UUID id) {
        TodoDTO todoDTO = todoService.getTodoById(id);
        return new ResponseEntity<>(todoDTO, HttpStatus.OK);
    }
}
