package com.lohithpuvvala.Online_Books_Store.controller;

import com.lohithpuvvala.Online_Books_Store.dto.UserInfoDto;
import com.lohithpuvvala.Online_Books_Store.service.UserInfoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/register")
    public ResponseEntity<String> createUserInfo(@RequestBody UserInfoDto userInfoDto) {
        UserInfoDto userInfoDto1 = userInfoService.createUser(userInfoDto);
        return new ResponseEntity<>("USER: "+userInfoDto.username()+" is created", HttpStatus.CREATED);
    }
}
