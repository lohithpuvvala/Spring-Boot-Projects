package com.lohithpuvvala.Online_Books_Store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetailsOne = User
                .withUsername("User1")
                .password(
                        passwordEncoder().encode("1234")
                )
                .build();

        UserDetails userDetailsTwo = User
                .withUsername("User2")
                .password(
                        passwordEncoder().encode("1234")
                )
                .build();

        UserDetails admin = User
                .withUsername("Admin")
                .password(
                        passwordEncoder().encode("1234")
                )
                .build();

        return new InMemoryUserDetailsManager(userDetailsOne, userDetailsTwo, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
