package dev.dmohindru.todoappbackend.repository.mongodb;

import dev.dmohindru.todoappbackend.entity.mongodb.TodoTitle;
import dev.dmohindru.todoappbackend.entity.mongodb.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoTitleRepository extends MongoRepository<TodoTitle, String> {
    List<TodoTitle> findTodoTitleByUser(User user);
}
