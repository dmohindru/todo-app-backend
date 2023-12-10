package dev.dmohindru.todoappbackend.dao.impl.mongodb;

import dev.dmohindru.todoappbackend.dao.UserDao;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.entity.mongodb.User;
import dev.dmohindru.todoappbackend.mapper.mongodb.UserMongoDBMapper;
import dev.dmohindru.todoappbackend.repository.mongodb.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("user-mongodb")
@RequiredArgsConstructor
public class UserDaoMongoDBImpl implements UserDao {

    private final UserRepository userRepository;
    private final UserMongoDBMapper userMapper = UserMongoDBMapper.INSTANCE;

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        return userMapper.getUserDTO(user);
    }

    @Override
    public UserDTO saveNewUser(UserDTO userDTO) {
        User user = userMapper.getUserEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.getUserDTO(savedUser);
    }
}
