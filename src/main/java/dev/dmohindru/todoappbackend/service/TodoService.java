package dev.dmohindru.todoappbackend.service;

import dev.dmohindru.todoappbackend.dto.TodoDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.entity.mongodb.Todo;

import java.util.List;
import java.util.UUID;

public interface TodoService {
    List<TodoDTO> getAllTodoByTitleId(String titleId);
    TodoDTO updateTodo(UserDTO userDTO, UUID todoTitleId, TodoDTO todoDTO);

    TodoDTO getTodoById(String id);

    TodoDTO createTodo(UserDTO userDTO, UUID todoListId, TodoDTO todoDTO);
}
