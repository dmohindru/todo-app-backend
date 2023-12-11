package dev.dmohindru.todoappbackend.mapper.mongodb;

import dev.dmohindru.todoappbackend.dto.TodoDTO;
import dev.dmohindru.todoappbackend.entity.mongodb.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoMongoDBMapper {
    TodoMongoDBMapper INSTANCE = Mappers.getMapper(TodoMongoDBMapper.class);

    @Mapping(source = "externalId", target = "id")
    TodoDTO getTodoDTO(Todo todo);

    @Mapping(source = "id", target = "externalId")
    Todo getTodoEntity(TodoDTO todoDTO);

}
