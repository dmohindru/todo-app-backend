package dev.dmohindru.todoappbackend.dao.impl.mongodb;

import dev.dmohindru.todoappbackend.dao.UserDao;
import dev.dmohindru.todoappbackend.dto.UserDTO;
import dev.dmohindru.todoappbackend.repository.mongodb.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("user-mongodb")
@RequiredArgsConstructor
public class UserDaoMongoDBImpl implements UserDao {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUserByUsername(String username) {
        return null;
    }

    @Override
    public UserDTO saveNewUser(UserDTO userDTO) {
        return null;
    }
}
