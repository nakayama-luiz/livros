package com.example.orliv.service;

import com.example.orliv.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class BookcaseServiceTest {

    @InjectMocks
    BookcaseService bookcaseService;

    @InjectMocks
    UserRepository userRepository;
    @Test
    void createBookcase() {


    }
}