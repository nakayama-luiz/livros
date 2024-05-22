package com.example.orliv.service;

import com.example.orliv.model.bookcases;
import com.example.orliv.model.opus;
import com.example.orliv.model.edition;
import com.example.orliv.model.enums.Status;
import com.example.orliv.model.user;
import com.example.orliv.repository.BookcaseRepository;
import com.example.orliv.repository.EditionRepository;
import com.example.orliv.repository.UserRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookcaseService {

    @Autowired
    private BookcaseRepository bookcaseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EditionRepository editionRepository;

    public bookcases createBookcase(bookcases bookcases, Long user_id){

        Set<Long> sem_maldade = new HashSet<>();

        System.out.println(bookcases.getEditions().getId());
        user user = userRepository.findById(user_id).orElseThrow(
                ()-> new EntityNotFoundException("User not found")
        );

        List<bookcases> userBookcases = bookcaseRepository.findAllByOwner(user);
        for (bookcases existingBookcase : userBookcases) {
            existingBookcase.getEditions().getOpuses().forEach(opus -> sem_maldade.add(opus.getId()));
        }


        for (opus opus : bookcases.getEditions().getOpuses()) {
            if (sem_maldade.contains(opus.getId())) {
                throw new RuntimeException("A edição com a mesma opus já existe.");
            }
        }
        for (bookcases existingBookcase : userBookcases) {

            sem_maldade.add(existingBookcase.getId());
//            if (existingBookcase.getEditions().getOpuses().equals(bookcases.getEditions().getOpuses())) {
//                throw new RuntimeException("A edição com a mesma opus já existe.");
//            }
        }


        bookcases.setOwner(user);
        return bookcaseRepository.save(bookcases);
    }

    public bookcases addEdtion(bookcases bookcases, Long edition_id){
        edition edition = editionRepository.findById(edition_id).orElseThrow(
                ()-> new EntityNotFoundException("Edition not found.")
        );
        bookcases.setEditions(edition);
        return bookcases;
    }

    public bookcases update(bookcases estante){
        return bookcaseRepository.save(estante);
    }

    public bookcases favorite(Long bookcase_id){
        bookcases bookcases = bookcaseRepository.findById(bookcase_id).orElseThrow();

        bookcases.setFavorite(true);
        return bookcaseRepository.save(bookcases);
    }

    public bookcases list(Long id){
        return bookcaseRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("mentiras pra miom")
        );
    }

    public Page<bookcases> findUserBookcases(Pageable pageable, Long id, Status status){

        user finded = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

        return bookcaseRepository.findByStatus(pageable, status, finded);

    }
}
