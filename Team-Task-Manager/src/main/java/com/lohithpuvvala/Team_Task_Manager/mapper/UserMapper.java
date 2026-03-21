package com.lohithpuvvala.Team_Task_Manager.mapper;

import com.lohithpuvvala.Team_Task_Manager.dto.UserDto;
import com.lohithpuvvala.Team_Task_Manager.model.User;

public class UserMapper {
    public static UserDto userToUserDto(User user) {
        return new UserDto(user.getUsername(), user.getPassword(), user.getRoles());
    }

    public static User userDtoToUser(UserDto userDto) {
        return new User(userDto.username(), userDto.password(), userDto.roles());
    }
}
