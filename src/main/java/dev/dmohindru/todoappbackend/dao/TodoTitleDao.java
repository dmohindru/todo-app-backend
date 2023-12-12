package dev.dmohindru.todoappbackend.dao;

import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;

import java.util.List;

public interface TodoTitleDao {
    List<TodoTitleDTO> getAllTodoTitleByUsername(String username);
    TodoTitleDTO updateTodoTitle(TodoTitleDTO todoTitleDTO);
    TodoTitleDTO getTodoTitleById(String todoTitleId);
    TodoTitleDTO saveTodoTitle(UserDTO userDTO, TodoTitleDTO todoTitleDTO);

}
