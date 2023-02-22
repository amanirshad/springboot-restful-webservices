package aman.irshad.springboot.service.impl;

import aman.irshad.springboot.dto.UserDto;
import aman.irshad.springboot.entity.User;
import aman.irshad.springboot.exception.ResourceNotFoundException;
import aman.irshad.springboot.mapper.AutoUserMapper;
import aman.irshad.springboot.mapper.UserMapper;
import aman.irshad.springboot.repository.UserRepository;
import aman.irshad.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {


        //convert userDto into User JPA entity
        //User user = UserMapper.mapToUser(userDto);


        //convert userDto into User JPA entity using ModelMapper
        //User user = modelMapper.map(userDto,User.class);

        //convert userDto into User JPA Entity using MapStruct
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);

        User savedUser = userRepository.save(user);


        //convert User JPA Entity to userDto
        //UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

        //convert User JPA Entity to userDto using ModelMapper
        //UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        //convert userDto into User JPA Entity using MapStruct
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);


        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );
        //User user = optionalUser.get();
        //return UserMapper.mapToUserDto(user);

        //return modelMapper.map(user, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto)
//                .collect(Collectors.toList());

//        return users.stream().map((user)->
//                modelMapper.map(user, UserDto.class))
//                .collect(Collectors.toList());

        return users.stream().map((user) ->
                        AutoUserMapper.MAPPER.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", user.getId())

        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        //return UserMapper.mapToUserDto(updatedUser);
        //return modelMapper.map(updatedUser, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );

        userRepository.deleteById(userId);
    }

}