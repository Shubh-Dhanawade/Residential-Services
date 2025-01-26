package com.example.backend.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(authorizeHttpRequests -> {
            authorizeHttpRequests.requestMatchers("/login", "/register","/userdata").permitAll();
            authorizeHttpRequests.anyRequest().authenticated();
        })
        .csrf(csrf->csrf.disable())
        .sessionManagement(sessionManagement->{
            sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        })
        .httpBasic(httpBasic ->{
            // httpBasic.disable();
        });

        return  http.build();
    }

    
}
