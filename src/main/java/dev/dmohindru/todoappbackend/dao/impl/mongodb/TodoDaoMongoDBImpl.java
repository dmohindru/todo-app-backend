package dev.dmohindru.todoappbackend.dao.impl.mongodb;

import dev.dmohindru.todoappbackend.dao.TodoDao;
import dev.dmohindru.todoappbackend.dto.TodoDTO;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.entity.mongodb.Todo;
import dev.dmohindru.todoappbackend.entity.mongodb.TodoTitle;
import dev.dmohindru.todoappbackend.entity.mongodb.User;
import dev.dmohindru.todoappbackend.exception.MissingRecordException;
import dev.dmohindru.todoappbackend.exception.UserNotFoundException;
import dev.dmohindru.todoappbackend.mapper.mongodb.TodoMongoDBMapper;
import dev.dmohindru.todoappbackend.repository.mongodb.TodoRepository;
import dev.dmohindru.todoappbackend.repository.mongodb.TodoTitleRepository;
import dev.dmohindru.todoappbackend.repository.mongodb.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import static dev.dmohindru.todoappbackend.dao.impl.mongodb.DaoUtils.checkForUserEquality;

import java.util.List;
import java.util.UUID;

@Component("todo-mongodb")
@RequiredArgsConstructor
public class TodoDaoMongoDBImpl implements TodoDao {

    private final UserRepository userRepository;

    private final TodoTitleRepository todoTitleRepository;

    private final TodoRepository todoRepository;

    private final TodoMongoDBMapper todoMongoDBMapper = TodoMongoDBMapper.INSTANCE;

    @Override
    public List<TodoDTO> getAllTodoByTitleId(String titleId) {
        return null;
    }

    @Override
    public TodoDTO updateTodo(UserDTO userDTO, UUID todoListId, TodoDTO todoDTO) {

        TodoTitle todoTitleList = getTodoTitleList(todoListId);

        User user = getUser(userDTO);

        checkForUserEquality(user, todoTitleList);

        Todo todo = todoRepository.findByExternalId(UUID.fromString(todoDTO.getId()))
                .orElseThrow(() -> new MissingRecordException(
                        String.format("Todo with id [%s] not found", todoDTO.getId()))
                );

        if (todoDTO.getTitle() != null) {
            todo.setTodoTitle(todoDTO.getTitle());
        }

        if (todoDTO.getDescription() != null) {
            todo.setDescription(todoDTO.getDescription());
        }

        if (todoDTO.getDone() != null) {
            todo.setDone(todoDTO.getDone());
        }

        Todo savedTodo = todoRepository.save(todo);

        return todoMongoDBMapper.getTodoDTO(savedTodo);
    }

    @Override
    public TodoDTO getTodoById(String id) {
        return null;
    }

    @Override
    public TodoDTO createTodo(UserDTO userDTO, UUID todoListId, TodoDTO todoDTO) {

        TodoTitle todoTitle = getTodoTitleList(todoListId);

        User user = getUser(userDTO);

        checkForUserEquality(user, todoTitle);

        Todo todoEntity = todoMongoDBMapper.getTodoEntity(todoDTO);
        todoEntity.setExternalId(UUID.randomUUID());
        todoEntity.setTodoTitleParent(todoTitle);

        Todo savedTodo = todoRepository.save(todoEntity);

        todoTitle.getTodoList().add(savedTodo);

        todoTitleRepository.save(todoTitle);

        return todoMongoDBMapper.getTodoDTO(savedTodo);
    }

    private User getUser(UserDTO userDTO) {
        User user = userRepository.findUserByUsername(userDTO.getUsername());
        if (user == null) {
            // This should not happen. But just in case
            throw new UserNotFoundException(String.format("User by username [%s] not found", userDTO.getUsername()));
        }
        return user;
    }

    private TodoTitle getTodoTitleList(UUID todoListId) {

        return todoTitleRepository
                .findTodoTitleByExternalId(todoListId)
                .orElseThrow(() ->
                        new MissingRecordException(String.format("Todo Title with id [%s] not found", todoListId)));

    }
}
