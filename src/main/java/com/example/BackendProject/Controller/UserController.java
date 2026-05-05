package com.example.BackendProject.Controller;


import com.example.BackendProject.Entities.UserModel;
import com.example.BackendProject.Respository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepo repo;
    @PostMapping
    public String login(@RequestBody UserModel model)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        model.setPassword(encoder.encode(model.getPassword()));

        return "sign up succesfull";
    }
}
