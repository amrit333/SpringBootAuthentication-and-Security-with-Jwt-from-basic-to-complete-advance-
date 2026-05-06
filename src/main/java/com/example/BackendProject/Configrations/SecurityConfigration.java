package com.example.BackendProject.Configrations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SecurityConfigration {

    private final PasswordEncoder encoder;

    public SecurityConfigration(PasswordEncoder encoder) {
        this.encoder = encoder;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security){

       return security.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request ->

                        request.requestMatchers("/user").permitAll()
                                .requestMatchers("/admin/**").hasRole("admin")
                                .anyRequest().authenticated()).formLogin(Customizer.withDefaults())
//            Agar meinu basic authentication v use karni hai postman te us lai eh liikhna zroori hai
               .httpBasic(Customizer.withDefaults())
                .build();

    }


    @Bean
    public UserDetailsService buildUser(){
    // is code naal mein jo user build kita hai oh username and password naal agar mein login krunga te mere kol
//        admint rights aa jange jo jo endpoints upar admin waste mein authenticate kite honge oh sare
//        enpoints nu eh user access kr sakda hai
//        currently eh sirf brower te ho riha hai

        UserDetails user = User.withUsername("amrit")

                // ithe is user nu password encoder neccesary chahida hai otherwise apa unu login nahi kar skda

                // and ithe jo marji tusi encoder use kar rhe ho isda ik bean banauna v zroori hai te mein eh bean build kita hai
//                meri Admin class Encoders di class ch PasswordEncoder lcass ch i know ke name built in encoder naal same ho gye
//                but hun mein admin nu jine endpoints da power diti hai oh sare endpints access kr sakda
                .password(encoder.encode("iamrit3"))
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration){
return configuration.getAuthenticationManager();
    }


}
