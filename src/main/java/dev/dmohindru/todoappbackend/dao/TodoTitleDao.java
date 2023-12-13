package dev.dmohindru.todoappbackend.dao;

import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface TodoTitleDao {
    List<TodoTitleDTO> getAllTodoTitleByUsername(String username);
    TodoTitleDTO updateTodoTitle(UserDTO userDTO, TodoTitleDTO todoTitleDTO);
    TodoTitleDTO getTodoTitleById(UUID todoTitleId);
    TodoTitleDTO saveTodoTitle(UserDTO userDTO, TodoTitleDTO todoTitleDTO);

    TodoTitleDTO deleteTodoTitle(UserDTO userDTO, UUID titleExternalId);

}
