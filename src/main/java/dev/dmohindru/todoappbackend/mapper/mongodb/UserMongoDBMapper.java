package dev.dmohindru.todoappbackend.mapper.mongodb;

import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.entity.mongodb.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMongoDBMapper {
    UserMongoDBMapper INSTANCE = Mappers.getMapper(UserMongoDBMapper.class);

    @Mapping(source = "externalId", target = "id")
    UserDTO getUserDTO(User user);

    @Mapping(source = "id", target = "externalId")
    User getUserEntity(UserDTO userDTO);
}
