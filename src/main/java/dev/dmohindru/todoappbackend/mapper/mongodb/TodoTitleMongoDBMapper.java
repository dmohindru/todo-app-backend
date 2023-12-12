package dev.dmohindru.todoappbackend.mapper.mongodb;

import dev.dmohindru.todoappbackend.dto.TodoTitleDTO;
import dev.dmohindru.todoappbackend.entity.mongodb.TodoTitle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        TodoMongoDBMapper.class
})
public interface TodoTitleMongoDBMapper {
    TodoTitleMongoDBMapper INSTANCE = Mappers.getMapper(TodoTitleMongoDBMapper.class);

    @Mapping(source = "externalId", target = "id")
    TodoTitleDTO getTodoTitleDTO(TodoTitle todoTitle);

    @Mapping(source = "id", target = "externalId")
    TodoTitle getTodoTitleEntity(TodoTitleDTO todoTitleDTO);
}
