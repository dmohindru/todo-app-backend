package dev.dmohindru.todoappbackend.repository.mongodb;

import dev.dmohindru.todoappbackend.entity.mongodb.TodoTitle;
import dev.dmohindru.todoappbackend.entity.mongodb.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TodoTitleRepository extends MongoRepository<TodoTitle, String> {
    List<TodoTitle> findTodoTitleByUser(User user);

    TodoTitle findTodoTitleByExternalId(UUID externalId);
}
