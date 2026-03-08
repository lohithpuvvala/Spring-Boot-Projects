package com.lohithpuvvala.Online_Books_Store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails userDetailsOne = User
//                .withUsername("User1")
//                .password(
//                        passwordEncoder().encode("1234")
//                )
//                .roles("USER")
//                .build();
//
//        UserDetails userDetailsTwo = User
//                .withUsername("User2")
//                .password(
//                        passwordEncoder().encode("1234")
//                )
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User
//                .withUsername("Admin")
//                .password(
//                        passwordEncoder().encode("1234")
//                )
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetailsOne, userDetailsTwo, admin);
//    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable());
        httpSecurity
                .authorizeHttpRequests(request ->
                        request.requestMatchers("/book-store/welcome","/user-info/register").permitAll()
                                .anyRequest().authenticated()
                );

        httpSecurity.httpBasic(
                Customizer.withDefaults()
       );
        httpSecurity.sessionManagement(
                session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
        );

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
}
