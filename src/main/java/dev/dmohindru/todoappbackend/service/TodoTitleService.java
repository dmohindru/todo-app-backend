package dev.dmohindru.todoappbackend.service;

import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;

import java.util.List;

public interface TodoTitleService {
    List<TodoTitleDTO> getAllTodoTitleByUsername(String username);

    TodoTitleDTO updateTodoTitle(TodoTitleDTO todoTitleDTO);

    TodoTitleDTO getTodoTitleById(String id);
}
