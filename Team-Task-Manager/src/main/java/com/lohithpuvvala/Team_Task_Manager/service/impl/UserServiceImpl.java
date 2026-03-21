package com.lohithpuvvala.Team_Task_Manager.service.impl;

import com.lohithpuvvala.Team_Task_Manager.dto.UserDto;
import com.lohithpuvvala.Team_Task_Manager.mapper.UserMapper;
import com.lohithpuvvala.Team_Task_Manager.model.User;
import com.lohithpuvvala.Team_Task_Manager.repository.UserRepository;
import com.lohithpuvvala.Team_Task_Manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
