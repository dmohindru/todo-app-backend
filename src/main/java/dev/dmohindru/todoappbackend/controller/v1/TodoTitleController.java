package dev.dmohindru.todoappbackend.controller.v1;

import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.service.TodoTitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static dev.dmohindru.todoappbackend.controller.v1.ControllerUtils.getUserDTO;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/todotitle")
@RequiredArgsConstructor
public class TodoTitleController {
    private final TodoTitleService todoTitleService;

    @PostMapping
    public ResponseEntity<TodoTitleDTO> createTodoTitle(@RequestBody TodoTitleDTO todoTitleDTO,
                                                       @RequestHeader Map<String, String> headers) {

        UserDTO userDTO = getUserDTO(headers);
        TodoTitleDTO savedTodoTitleDTO = todoTitleService.saveTodoTitle(userDTO, todoTitleDTO);

        return new ResponseEntity<>(savedTodoTitleDTO, HttpStatus.CREATED);

    }

    @PatchMapping
    public ResponseEntity<TodoTitleDTO> patchTodoTitle(@RequestBody TodoTitleDTO todoTitleDTO,
                                                       @RequestHeader Map<String, String> headers) {

        UserDTO userDTO = getUserDTO(headers);
        TodoTitleDTO updaedTodoTitleDTO = todoTitleService.updateTodoTitle(userDTO, todoTitleDTO);
        return new ResponseEntity<>(updaedTodoTitleDTO, HttpStatus.ACCEPTED);
    }
}
