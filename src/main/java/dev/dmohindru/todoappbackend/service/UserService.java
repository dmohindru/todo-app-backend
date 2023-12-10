package dev.dmohindru.todoappbackend.service;

import dev.dmohindru.todoappbackend.dto.UserDTO;

public interface UserService {
    UserDTO getUserByUsername(String username);

    UserDTO getUserTodoList(UserDTO userDTO);
}
