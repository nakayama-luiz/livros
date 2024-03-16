package com.example.orliv.service;

import com.example.orliv.model.author;
import com.example.orliv.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    public author getAuthorById(Long id){
        return authorRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Author not found")
        );
    }

}
