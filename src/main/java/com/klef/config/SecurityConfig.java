package com.klef.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for APIs
            .cors(cors -> {})             // ✅ enable CORS
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/**").permitAll() // allow all endpoints (dev)
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
