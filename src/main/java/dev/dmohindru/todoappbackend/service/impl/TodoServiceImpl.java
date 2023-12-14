package dev.dmohindru.todoappbackend.service.impl;

import dev.dmohindru.todoappbackend.dao.TodoDao;
import dev.dmohindru.todoappbackend.dto.TodoDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.entity.mongodb.Todo;
import dev.dmohindru.todoappbackend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoDao todoDao;
    @Override
    public List<TodoDTO> getAllTodoByTitleId(String titleId) {
        return null;
    }

    @Override
    public TodoDTO updateTodo(UserDTO userDTO, UUID todoListId, TodoDTO todoDTO) {
        return todoDao.updateTodo(userDTO, todoListId, todoDTO);
    }

    @Override
    public TodoDTO getTodoById(String id) {
        return null;
    }

    @Override
    public TodoDTO createTodo(UserDTO userDTO, UUID todoTitleId, TodoDTO todoDTO) {
        return todoDao.createTodo(userDTO, todoTitleId, todoDTO);
    }

    @Override
    public TodoDTO deleteTodo(UserDTO userDTO, UUID todoTitleId, UUID todoId) {
        return todoDao.deleteTodo(userDTO, todoTitleId, todoId);
    }

    @Override
    public TodoDTO getTodoById(UUID id) {
        return todoDao.getTodoById(id);
    }
}
