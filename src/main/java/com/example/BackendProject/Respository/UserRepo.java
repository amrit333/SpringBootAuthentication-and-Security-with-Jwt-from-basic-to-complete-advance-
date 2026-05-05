package com.example.BackendProject.Respository;

import com.example.BackendProject.Entities.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface UserRepo extends MongoRepository<UserModel,String> {
}
