package aman.irshad.springboot.service.impl;

import aman.irshad.springboot.entity.User;
import aman.irshad.springboot.repository.UserRepository;
import aman.irshad.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
