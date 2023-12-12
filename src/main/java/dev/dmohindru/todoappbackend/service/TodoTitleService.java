package dev.dmohindru.todoappbackend.service;

import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface TodoTitleService {
    List<TodoTitleDTO> getAllTodoTitleByUsername(UserDTO userDTO);

    TodoTitleDTO updateTodoTitle(TodoTitleDTO todoTitleDTO);

    TodoTitleDTO getTodoTitleById(UUID id);

    TodoTitleDTO saveTodoTitle(UserDTO userDTO, TodoTitleDTO todoTitleDTO);
}
