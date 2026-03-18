package com.lohithpuvvala.Team_Task_Manager.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}1234")//bcrpt form of "1234" is "{bcrpt}$2a$10$Sr77BJSenQIVhWdpWZhVyeGM/rN/xdkTo37b78OW5Z45VwtYwf4D2"
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
