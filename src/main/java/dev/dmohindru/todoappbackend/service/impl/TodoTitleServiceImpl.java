package dev.dmohindru.todoappbackend.service.impl;

import dev.dmohindru.todoappbackend.dao.TodoTitleDao;
import dev.dmohindru.todoappbackend.dao.UserDao;
import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.service.TodoTitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoTitleServiceImpl implements TodoTitleService {

    private final TodoTitleDao todoTitleDao;

    @Override
    public List<TodoTitleDTO> getAllTodoTitleByUsername(UserDTO userDTO) {
        return null;
    }

    @Override
    public TodoTitleDTO updateTodoTitle(TodoTitleDTO todoTitleDTO) {
        return null;
    }

    @Override
    public TodoTitleDTO getTodoTitleById(UUID id) {
        return null;
    }

    @Override
    public TodoTitleDTO saveTodoTitle(UserDTO userDTO, TodoTitleDTO todoTitleDTO) {
        return todoTitleDao.saveTodoTitle(userDTO, todoTitleDTO);
    }
}
