package dev.dmohindru.todoappbackend.mapper.mongodb;

import dev.dmohindru.todoappbackend.dto.TodoDTO;
import dev.dmohindru.todoappbackend.entity.mongodb.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoMongoDBMapper {
    TodoMongoDBMapper INSTANCE = Mappers.getMapper(TodoMongoDBMapper.class);

    TodoDTO getTodoDTO(Todo todo);

    Todo getTodoEntity(TodoDTO todoDTO);

}
