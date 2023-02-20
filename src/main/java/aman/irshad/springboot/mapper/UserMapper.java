package aman.irshad.springboot.mapper;

import aman.irshad.springboot.dto.UserDto;
import aman.irshad.springboot.entity.User;

public class UserMapper {

    // Convert User JPA Entity to UserDto
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }

    // Convert UserDto to User JPA Entity
    public static User mapToUser(UserDto userDto){
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail()
        );
        return user;
    }
}
