//package com.lohithpuvvala.Team_Task_Manager.configuration;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return User.builder()
//                .username("user")
//                .password("$2a$10$Sr77BJSenQIVhWdpWZhVyeGM/rN/xdkTo37b78OW5Z45VwtYwf4D2")//bcrpt form of "1234" is "{bcrpt}$2a$10$Sr77BJSenQIVhWdpWZhVyeGM/rN/xdkTo37b78OW5Z45VwtYwf4D2"
//                .build();
//    }
//}
