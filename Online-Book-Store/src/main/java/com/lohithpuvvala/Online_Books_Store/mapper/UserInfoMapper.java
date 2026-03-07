package com.lohithpuvvala.Online_Books_Store.mapper;

import com.lohithpuvvala.Online_Books_Store.dto.UserInfoDto;
import com.lohithpuvvala.Online_Books_Store.entity.UserInfo;

public class UserInfoMapper {
    public static UserInfoDto toDto(UserInfo userInfo){
        return new UserInfoDto(
                userInfo.getUsername(),
                userInfo.getPassword(),
                userInfo.getRoles()
        );
    }

    public static UserInfo toEntity(UserInfoDto userInfoDto){
        return new UserInfo(
                userInfoDto.username(),
                userInfoDto.password(),
                userInfoDto.roles()
        );
    }
}
