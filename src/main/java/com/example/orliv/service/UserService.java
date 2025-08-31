package com.example.orliv.service;

import com.example.orliv.domain.User;
import com.example.orliv.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends GenericCrudService<User, Long> {

    public UserService(UserRepository repository) {
        super(repository);
    }

    public List<User> findByName(String name) {
        return this.getRepository(UserRepository.class).findAllByUsername(name);
    }

}
