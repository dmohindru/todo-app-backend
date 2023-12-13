package dev.dmohindru.todoappbackend.dao.impl.mongodb;

import dev.dmohindru.todoappbackend.dao.TodoTitleDao;
import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.entity.mongodb.TodoTitle;
import dev.dmohindru.todoappbackend.entity.mongodb.User;
import dev.dmohindru.todoappbackend.exception.MissingRecordException;
import dev.dmohindru.todoappbackend.exception.UnauthorizedException;
import dev.dmohindru.todoappbackend.exception.UserNotFoundException;
import dev.dmohindru.todoappbackend.mapper.mongodb.TodoTitleMongoDBMapper;
import dev.dmohindru.todoappbackend.repository.mongodb.TodoTitleRepository;
import dev.dmohindru.todoappbackend.repository.mongodb.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import static dev.dmohindru.todoappbackend.dao.impl.mongodb.DaoUtils.checkForUserEquality;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component("todo-title-mongodb")
@RequiredArgsConstructor
public class TodoTitleDaoMongoDBImpl implements TodoTitleDao {

    private final TodoTitleRepository todoTitleRepository;

    private final UserRepository userRepository;

    private final TodoTitleMongoDBMapper todoTitleMongoDBMapper = TodoTitleMongoDBMapper.INSTANCE;
    @Override
    public List<TodoTitleDTO> getAllTodoTitleByUsername(String username) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TodoTitleDTO updateTodoTitle(UserDTO userDTO, TodoTitleDTO todoTitleDTO) {
        User user = getUser(userDTO);

        TodoTitle foundTodoTitle = todoTitleRepository
                .findTodoTitleByExternalId(UUID.fromString(todoTitleDTO.getId()))
                .orElseThrow(() -> new MissingRecordException(String.format("Todo Title with id [%s] not found", todoTitleDTO.getId())));


        checkForUserEquality(user, foundTodoTitle);

        if (todoTitleDTO.getTitleName() != null) {
            foundTodoTitle.setTitleName(todoTitleDTO.getTitleName());
        }

        if (todoTitleDTO.getDescription() != null) {
            foundTodoTitle.setDescription(todoTitleDTO.getDescription());
        }

        TodoTitle savedTodoTitle = todoTitleRepository.save(foundTodoTitle);

        return todoTitleMongoDBMapper.getTodoTitleDTO(savedTodoTitle);
    }

    @Override
    public TodoTitleDTO getTodoTitleById(UUID todoTitleId) {
        TodoTitle todoTitle = todoTitleRepository
                .findTodoTitleByExternalId(todoTitleId)
                .orElseThrow(() -> new MissingRecordException(String.format("Todo Title with id [%s] not found", todoTitleId)));

        return todoTitleMongoDBMapper.getTodoTitleDTO(todoTitle);
    }

    @Override
    public TodoTitleDTO saveTodoTitle(UserDTO userDTO, TodoTitleDTO todoTitleDTO) {
        User user = getUser(userDTO);

        TodoTitle todoTitle = todoTitleMongoDBMapper.getTodoTitleEntity(todoTitleDTO);
        todoTitle.setExternalId(UUID.randomUUID());
        todoTitle.setUser(user);

        TodoTitle savedTodoTitle = todoTitleRepository.save(todoTitle);

        user.getTodoTitleList().add(todoTitle);

        userRepository.save(user);

        return todoTitleMongoDBMapper.getTodoTitleDTO(savedTodoTitle);
    }

    @Override
    public TodoTitleDTO deleteTodoTitle(UserDTO userDTO, UUID titleExternalId) {
        User user = getUser(userDTO);

        TodoTitle foundTodoTitle = todoTitleRepository
                .findTodoTitleByExternalId(titleExternalId)
                .orElseThrow(() -> new MissingRecordException(String.format("Todo Title with id [%s] not found", titleExternalId)));

        checkForUserEquality(user, foundTodoTitle);

        List<TodoTitle> trimmedTodoList = user.getTodoTitleList()
                .stream()
                .filter(todoTitle -> !todoTitle.getExternalId().equals(titleExternalId))
                .toList();

        user.setTodoTitleList(trimmedTodoList);
        userRepository.save(user);

        foundTodoTitle.setDeleted(true);
        TodoTitle deletedTodoTitle = todoTitleRepository.save(foundTodoTitle);
        return todoTitleMongoDBMapper.getTodoTitleDTO(deletedTodoTitle);
    }

    private User getUser(UserDTO userDTO) {
        User user = userRepository.findUserByUsername(userDTO.getUsername());
        if (user == null) {
            // This should not happen. But just in case
            throw new UserNotFoundException(String.format("User by username [%s] not found", userDTO.getUsername()));
        }
        return user;
    }
}
