package aman.irshad.springboot.service;

import aman.irshad.springboot.entity.User;

public interface UserService {

    User createUser(User user);

    User getUserById(Long userId);
}
