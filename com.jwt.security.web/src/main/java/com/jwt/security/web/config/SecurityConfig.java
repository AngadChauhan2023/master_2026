package com.jwt.security.web.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.jwt.security.web.filter.JwtFilter;
import com.jwt.security.web.service.UserDetailService;
import com.jwt.security.web.util.JwtUtil;

@Configuration
public class SecurityConfig {

    private final JwtUtil jwtUtil;
    private final UserDetailService userService;

    public SecurityConfig(JwtUtil jwtUtil, UserDetailService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new JwtFilter(jwtUtil, userService), org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
