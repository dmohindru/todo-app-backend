package dev.dmohindru.todoappbackend.service.impl;

import dev.dmohindru.todoappbackend.dao.TodoTitleDao;
import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.service.TodoTitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoTitleServiceImpl implements TodoTitleService {

    private final TodoTitleDao todoTitleDao;

    @Override
    public List<TodoTitleDTO> getAllTodoTitleByUsername(String username) {
        return null;
    }

    @Override
    public TodoTitleDTO updateTodoTitle(TodoTitleDTO todoTitleDTO) {
        return null;
    }

    @Override
    public TodoTitleDTO getTodoTitleById(String id) {
        return null;
    }
}
