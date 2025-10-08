package com.example.habit_tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()   // allow all endpoints
                )
                .csrf(csrf -> csrf.disable())       // disable CSRF for forms
                .formLogin(form -> form.disable())  // disable login page
                .httpBasic(basic -> basic.disable()); // disable HTTP basic auth
        return http.build();
    }
}
