package dev.dmohindru.todoappbackend.service.impl;


import dev.dmohindru.todoappbackend.dao.TodoDao;
import dev.dmohindru.todoappbackend.dao.TodoTitleDao;
import dev.dmohindru.todoappbackend.dao.UserDao;
import dev.dmohindru.todoappbackend.dto.TodoDTO;
import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final TodoTitleDao todoTitleDao;

    private final TodoDao todoDao;

    @Override
    public UserDTO getUserByUsername(String username) {
        return null;
    }

    @Override
    public UserDTO getUserTodoList(UserDTO userDTO) {

        UserDTO foundUser = userDao.getUserByUsername(userDTO.getUsername());
        if (foundUser == null) {
            // new user don't have any todoTitles and todos as of now
            return userDao.saveNewUser(userDTO);
        }

        return foundUser;

    }
}
