package dev.dmohindru.todoappbackend.repository.mongodb;

import dev.dmohindru.todoappbackend.entity.mongodb.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByUsername(String username);
}
