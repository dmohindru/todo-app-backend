package dev.dmohindru.todoappbackend.repository.mongodb;

import dev.dmohindru.todoappbackend.entity.mongodb.Todo;
import dev.dmohindru.todoappbackend.entity.mongodb.TodoTitle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> findAllByTodoTitleParent(TodoTitle parent);
}
