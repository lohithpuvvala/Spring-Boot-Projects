package com.lohithpuvvala.Team_Task_Manager.service.impl;

import com.lohithpuvvala.Team_Task_Manager.mapper.UserDetailsMapper;
import com.lohithpuvvala.Team_Task_Manager.model.User;
import com.lohithpuvvala.Team_Task_Manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(username);
        return user.map(UserDetailsMapper::new)
                .orElseThrow(() -> new UsernameNotFoundException("User "+username+" NOT FOUND"));
    }
}
