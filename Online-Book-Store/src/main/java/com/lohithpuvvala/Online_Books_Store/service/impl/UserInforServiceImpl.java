package com.lohithpuvvala.Online_Books_Store.service.impl;

import com.lohithpuvvala.Online_Books_Store.dto.UserInfoDto;
import com.lohithpuvvala.Online_Books_Store.entity.UserInfo;
import com.lohithpuvvala.Online_Books_Store.mapper.UserInfoMapper;
import com.lohithpuvvala.Online_Books_Store.repository.UserInfoRepository;
import com.lohithpuvvala.Online_Books_Store.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInforServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public UserInfoDto createUser(UserInfoDto userInfoDto) {
        UserInfo userInfo = UserInfoMapper.toEntity(userInfoDto);
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return UserInfoMapper.toDto(userInfo);
    }
}
