package aman.irshad.springboot.service;

import aman.irshad.springboot.dto.UserDto;
import aman.irshad.springboot.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);
}
