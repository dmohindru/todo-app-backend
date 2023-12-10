package dev.dmohindru.todoappbackend.dao.impl.mongodb;

import dev.dmohindru.todoappbackend.dao.TodoDao;
import dev.dmohindru.todoappbackend.dto.TodoDTO;
import dev.dmohindru.todoappbackend.repository.mongodb.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("mongodb")
@RequiredArgsConstructor
public class TodoDaoMongoDBImpl implements TodoDao {

    private final TodoRepository todoRepository;
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
