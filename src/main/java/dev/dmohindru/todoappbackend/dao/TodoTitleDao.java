package dev.dmohindru.todoappbackend.dao;

import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;

import java.util.List;

public interface TodoTitleDao {
    List<TodoTitleDTO> getAllTodoTitleByUsername(String username);
    TodoTitleDTO updateTodoTitle(TodoTitleDTO todoTitleDTO);
    TodoTitleDTO getTodoTitleById(String todoTitleId);

}
