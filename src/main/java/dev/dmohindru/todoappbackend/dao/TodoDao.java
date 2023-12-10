package dev.dmohindru.todoappbackend.dao;

import dev.dmohindru.todoappbackend.dto.TodoDTO;

import java.util.List;

public interface TodoDao {
    List<TodoDTO> getAllTodoByTitleId(String titleId);

    TodoDTO updateTodo(TodoDTO todoDTO);

    TodoDTO getTodoById(String id);
}
