package dev.dmohindru.todoappbackend.dao;

import dev.dmohindru.todoappbackend.dto.TodoDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface TodoDao {
    List<TodoDTO> getAllTodoByTitleId(String titleId);

    TodoDTO updateTodo(UserDTO userDTO, UUID todoTitleId, TodoDTO todoDTO);

    TodoDTO getTodoById(String id);

    TodoDTO createTodo(UserDTO userDTO, UUID todoTitleId, TodoDTO todoDTO);
}
