package com.example.orliv.service;
import com.example.orliv.model.bookcases;
import com.example.orliv.model.user;
import com.example.orliv.repository.BookcaseRepository;
import com.example.orliv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookcaseRepository bookcaseRepository;


    public user createUser(user _user){
        user novo = userRepository.save(_user);

        return novo;
    }

    public List<user> findByName(String name){
        return userRepository.findAllByUsername(name);
    }
}
