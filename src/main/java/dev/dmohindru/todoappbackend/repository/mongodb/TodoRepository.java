package dev.dmohindru.todoappbackend.repository.mongodb;

import dev.dmohindru.todoappbackend.entity.mongodb.Todo;
import dev.dmohindru.todoappbackend.entity.mongodb.TodoTitle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> findAllByTodoTitleParent(TodoTitle parent);
}
