package dev.dmohindru.todoappbackend.dao;

import dev.dmohindru.todoappbackend.dto.UserDTO;

public interface UserDao {
    UserDTO getUserByUsername(String username);
}
