package dev.dmohindru.todoappbackend.mapper.mongodb;

import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.entity.mongodb.TodoTitle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoTitleMongoDBMapper {
    TodoTitleMongoDBMapper INSTANCE = Mappers.getMapper(TodoTitleMongoDBMapper.class);

    TodoTitleDTO getTodoTitleDTO(TodoTitle todoTitle);

    TodoTitle getTodoTitleEntity(TodoTitleDTO todoTitleDTO);
}
