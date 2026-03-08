package com.lohithpuvvala.Online_Books_Store.service.impl;

import com.lohithpuvvala.Online_Books_Store.entity.UserInfo;
import com.lohithpuvvala.Online_Books_Store.mapper.UserInfoUserDetailsMapper;
import com.lohithpuvvala.Online_Books_Store.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserInfoUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findByUsername(username);
        return userInfoOptional.map(UserInfoUserDetailsMapper::new)
                .orElseThrow(() -> new UsernameNotFoundException("User:"+username+" not found"));
    }
}
