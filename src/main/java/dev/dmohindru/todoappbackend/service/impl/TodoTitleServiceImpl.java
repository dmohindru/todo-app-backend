package dev.dmohindru.todoappbackend.service.impl;

import dev.dmohindru.todoappbackend.dao.TodoTitleDao;
import dev.dmohindru.todoappbackend.dao.UserDao;
import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.exception.MissingIdException;
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
    public TodoTitleDTO updateTodoTitle(UserDTO userDTO, TodoTitleDTO todoTitleDTO) {
        if (todoTitleDTO.getId() == null) {
            throw new MissingIdException("Id filed missing for TodoTitle patch request");
        }

        return todoTitleDao.updateTodoTitle(userDTO, todoTitleDTO);
    }

    @Override
    public TodoTitleDTO getTodoTitleById(UUID id) {
        return todoTitleDao.getTodoTitleById(id);
    }

    @Override
    public TodoTitleDTO saveTodoTitle(UserDTO userDTO, TodoTitleDTO todoTitleDTO) {
        return todoTitleDao.saveTodoTitle(userDTO, todoTitleDTO);
    }

    @Override
    public TodoTitleDTO deleteTodoTitle(UserDTO userDTO, UUID todoTitleId) {
        return todoTitleDao.deleteTodoTitle(userDTO, todoTitleId);
    }
}
