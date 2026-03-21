package com.lohithpuvvala.Team_Task_Manager.service;

import com.lohithpuvvala.Team_Task_Manager.dto.UserDto;
import com.lohithpuvvala.Team_Task_Manager.model.User;

public interface UserService {
    public User createUser(UserDto userDto);
}
