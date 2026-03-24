package com.lohithpuvvala.Team_Task_Manager.controller;

import com.lohithpuvvala.Team_Task_Manager.dto.UserDto;
import com.lohithpuvvala.Team_Task_Manager.mapper.UserMapper;
import com.lohithpuvvala.Team_Task_Manager.model.User;
import com.lohithpuvvala.Team_Task_Manager.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user-api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {

        User createUser = userService.createUser(userDto);
        return new ResponseEntity<>("User created: "+ createUser.getUsername() +"\n "+createUser.toString(), HttpStatus.CREATED);
    }
}
