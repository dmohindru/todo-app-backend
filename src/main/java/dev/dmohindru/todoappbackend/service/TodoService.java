package dev.dmohindru.todoappbackend.service;

import dev.dmohindru.todoappbackend.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    List<TodoDTO> getAllTodoByTitleId(String titleId);
    TodoDTO updateTodo(TodoDTO todoDTO);

    TodoDTO getTodoById(String id);
}
