package dev.dmohindru.todoappbackend.service.impl;

import dev.dmohindru.todoappbackend.dao.TodoDao;
import dev.dmohindru.todoappbackend.dto.TodoDTO;
import dev.dmohindru.todoappbackend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoDao todoDao;
    @Override
    public List<TodoDTO> getAllTodoByTitleId(String titleId) {
        return null;
    }

    @Override
    public TodoDTO updateTodo(TodoDTO todoDTO) {
        return null;
    }

    @Override
    public TodoDTO getTodoById(String id) {
        return null;
    }
}
