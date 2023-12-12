package dev.dmohindru.todoappbackend.dao.impl.mongodb;

import dev.dmohindru.todoappbackend.dao.TodoTitleDao;
import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.entity.mongodb.TodoTitle;
import dev.dmohindru.todoappbackend.entity.mongodb.User;
import dev.dmohindru.todoappbackend.exception.UserNotFoundException;
import dev.dmohindru.todoappbackend.mapper.mongodb.TodoTitleMongoDBMapper;
import dev.dmohindru.todoappbackend.repository.mongodb.TodoTitleRepository;
import dev.dmohindru.todoappbackend.repository.mongodb.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component("todo-title-mongodb")
@RequiredArgsConstructor
public class TodoTitleDaoMongoDBImpl implements TodoTitleDao {

    private final TodoTitleRepository todoTitleRepository;

    private final UserRepository userRepository;

    private final TodoTitleMongoDBMapper todoTitleMongoDBMapper = TodoTitleMongoDBMapper.INSTANCE;
    @Override
    public List<TodoTitleDTO> getAllTodoTitleByUsername(String username) {
        return null;
    }

    @Override
    public TodoTitleDTO updateTodoTitle(TodoTitleDTO todoTitleDTO) {
        return null;
    }

    @Override
    public TodoTitleDTO getTodoTitleById(String todoTitleId) {
        return null;
    }

    @Override
    public TodoTitleDTO saveTodoTitle(UserDTO userDTO, TodoTitleDTO todoTitleDTO) {
        User user = userRepository.findUserByUsername(userDTO.getUsername());
        if (user == null) {
            // This should not happen. But just in case
            throw new UserNotFoundException(String.format("User by username [%s] not found", userDTO.getUsername()));
        }

        TodoTitle todoTitle = todoTitleMongoDBMapper.getTodoTitleEntity(todoTitleDTO);
        todoTitle.setExternalId(UUID.randomUUID());

        TodoTitle savedTodoTitle = todoTitleRepository.save(todoTitle);

        user.getTodoTitleList().add(todoTitle);

        userRepository.save(user);

        return todoTitleMongoDBMapper.getTodoTitleDTO(savedTodoTitle);
    }
}
