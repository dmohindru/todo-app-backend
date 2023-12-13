package dev.dmohindru.todoappbackend.repository.mongodb;

import dev.dmohindru.todoappbackend.entity.mongodb.TodoTitle;
import dev.dmohindru.todoappbackend.entity.mongodb.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TodoTitleRepository extends MongoRepository<TodoTitle, String> {

    Optional<TodoTitle> findTodoTitleByExternalId(UUID externalId);
}
