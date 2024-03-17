package com.example.orliv.service;

import com.example.orliv.model.bookcases;
import com.example.orliv.model.edition;
import com.example.orliv.model.user;
import com.example.orliv.repository.BookcaseRepository;
import com.example.orliv.repository.EditionRepository;
import com.example.orliv.repository.UserRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookcaseService {

    @Autowired
    private BookcaseRepository bookcaseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EditionRepository editionRepository;

    public bookcases createBookcase(bookcases bookcases, Long user_id){

        user user = userRepository.findById(user_id).orElseThrow(
                ()-> new EntityNotFoundException("User not found")
        );
        bookcases.setOwner(user);
        return bookcaseRepository.save(bookcases);
    }

    public bookcases addEdtion(bookcases bookcases, Long edition_id){
        edition edition = editionRepository.findById(edition_id).orElseThrow(
                ()-> new EntityNotFoundException("Edition not found.")
        );
        bookcases.getEditions().add(edition);
        return bookcases;
    }

}
