package aman.irshad.springboot.service;

import aman.irshad.springboot.dto.UserDto;
import aman.irshad.springboot.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
