package dev.dmohindru.todoappbackend.dao.impl.mongodb;

import dev.dmohindru.todoappbackend.dao.TodoTitleDao;
import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.repository.mongodb.TodoTitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("mongodb")
@RequiredArgsConstructor
public class TodoTitleDaoMongoDBImpl implements TodoTitleDao {

    private final TodoTitleRepository todoTitleRepository;
    @Override
    public List<TodoTitleDTO> getAllTodoTitleByUsername(String username) {
        return null;
    }

    @Override
    public TodoTitleDTO updateTodoTitle(TodoTitleDTO todoTitleDTO) {
        return null;
    }

    @Override
    public TodoTitleDTO getTodoTitleById(String todoTitleId) {
        return null;
    }
}
