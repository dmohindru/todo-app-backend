package dev.dmohindru.todoappbackend.dao.impl.mongodb;

import dev.dmohindru.todoappbackend.entity.mongodb.TodoTitle;
import dev.dmohindru.todoappbackend.entity.mongodb.User;
import dev.dmohindru.todoappbackend.exception.UnauthorizedException;

public class DaoUtils {
    static void checkForUserEquality(User user, TodoTitle todoTitle) {
        if (!todoTitle.getUser().getUsername().equalsIgnoreCase(user.getUsername())) {
            throw new UnauthorizedException(
                    String.format("User details in request headers not matched with recorded user against todoTitle with id [%s]", todoTitle.getExternalId()));
        }
    }
}
