package com.example.BackendProject.Entities;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class UserModel {
    private String  username;
    private String course;
    private String password;
    private String role;


}
