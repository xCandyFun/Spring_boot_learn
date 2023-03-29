package com.example.springdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/error").permitAll()
                .requestMatchers("/api/game").authenticated()
                .anyRequest().denyAll()
                .and()
                .formLogin()
                .defaultSuccessUrl("/api/game")
                .and()
                .build();
    }
}
