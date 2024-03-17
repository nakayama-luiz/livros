package com.example.orliv.service;
import com.example.orliv.model.user;
import com.example.orliv.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;


    public user createUser(user user){
        return userRepository.save(user);
    }
}
