package com.example.BackendProject.Configrations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security){

       return security.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request ->
                        request.requestMatchers("/user").permitAll()
                                .anyRequest().authenticated()).formLogin(Customizer.withDefaults())
                .build();

    }



}
