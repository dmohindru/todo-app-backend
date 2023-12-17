package dev.dmohindru.todoappbackend.controller.v1;

import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.service.TodoTitleService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static dev.dmohindru.todoappbackend.controller.v1.ControllerUtils.getUserDTO;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todotitle")
@RequiredArgsConstructor
public class TodoTitleController {
    private final TodoTitleService todoTitleService;

    @PostMapping
    public ResponseEntity<TodoTitleDTO> createTodoTitle(@RequestBody TodoTitleDTO todoTitleDTO,
                                                        HttpServletRequest request) {

        UserDTO userDTO = getUserDTO(request);
        TodoTitleDTO savedTodoTitleDTO = todoTitleService.saveTodoTitle(userDTO, todoTitleDTO);

        return new ResponseEntity<>(savedTodoTitleDTO, HttpStatus.CREATED);

    }

    @PatchMapping
    public ResponseEntity<TodoTitleDTO> patchTodoTitle(@RequestBody TodoTitleDTO todoTitleDTO,
                                                       HttpServletRequest request) {

        UserDTO userDTO = getUserDTO(request);
        TodoTitleDTO updaedTodoTitleDTO = todoTitleService.updateTodoTitle(userDTO, todoTitleDTO);
        return new ResponseEntity<>(updaedTodoTitleDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{titleId}")
    public ResponseEntity<TodoTitleDTO> deleteTodoTitle(@PathVariable("titleId") UUID id,
                                                        HttpServletRequest request) {
        UserDTO userDTO = getUserDTO(request);
        TodoTitleDTO deleteTodoTitle = todoTitleService.deleteTodoTitle(userDTO, id);
        return new ResponseEntity<>(deleteTodoTitle, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{titleId}")
    public ResponseEntity<TodoTitleDTO> getTodoTitle(@PathVariable("titleId") UUID id) {
        TodoTitleDTO todoTitleDTO = todoTitleService.getTodoTitleById(id);
        return new ResponseEntity<>(todoTitleDTO, HttpStatus.OK);
    }
}
