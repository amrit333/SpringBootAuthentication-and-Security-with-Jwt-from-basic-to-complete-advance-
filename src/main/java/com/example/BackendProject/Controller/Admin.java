package com.example.BackendProject.Controller;

import com.example.BackendProject.Entities.UserModel;
import com.example.BackendProject.Respository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class Admin {

    private final UserRepo repo;

    @GetMapping()
    public ArrayList<UserModel> getall(){
        return (ArrayList<UserModel>) repo.findAll();
    }

}
