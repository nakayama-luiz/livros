package com.example.orliv.service;

import com.example.orliv.domain.Bookcases;
import com.example.orliv.domain.Edition;
import com.example.orliv.domain.Opus;
import com.example.orliv.domain.User;
import com.example.orliv.domain.enums.Status;
import com.example.orliv.repository.BookcaseRepository;
import com.example.orliv.repository.EditionRepository;
import com.example.orliv.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BookcaseService {

    private BookcaseRepository bookcaseRepository;
    private UserRepository userRepository;
    private EditionRepository editionRepository;

    public Bookcases createBookcase(Bookcases bookcases, Long user_id) {

        Set<Long> sem_maldade = new HashSet<>();

        System.out.println(bookcases.getEditions().getId());
        User user = userRepository.findById(user_id).orElseThrow(
                ()-> new EntityNotFoundException("User not found")
        );

        List<Bookcases> userBookcases = bookcaseRepository.findAllByOwner(user);

        userBookcases.forEach(existingBookcase ->
                existingBookcase.getEditions().getOpuses().forEach(opus -> sem_maldade.add(opus.getId()))
        );

        List<Opus> games = bookcases.getEditions().getOpuses()
                .stream().filter(opus -> sem_maldade.contains(opus.getId()))
                .toList();

        if (!games.isEmpty()) {
            throw new IllegalArgumentException("Inaceitável");
        }

        for (Bookcases existingBookcase : userBookcases) {
            sem_maldade.add(existingBookcase.getId());
        }

        bookcases.setOwner(user);
        return bookcaseRepository.save(bookcases);
    }

    public Bookcases addEdtion(Bookcases bookcases, Long edition_id) {
        Edition edition = editionRepository.findById(edition_id).orElseThrow(
                ()-> new EntityNotFoundException("Edition not found.")
        );
        bookcases.setEditions(edition);
        return bookcases;
    }

    public Bookcases update(Bookcases estante) {
        return bookcaseRepository.save(estante);
    }

    public Bookcases favorite(Long bookcase_id) {
        Bookcases bookcases = bookcaseRepository.findById(bookcase_id).orElseThrow();

        bookcases.setFavorite(Boolean.TRUE);
        return bookcaseRepository.save(bookcases);
    }

    public Bookcases list(Long id) {
        return bookcaseRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("mentiras pra miom")
        );
    }

    public Page<Bookcases> findUserBookcases(Pageable pageable, Long id, Status status) {

        User found = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

        return bookcaseRepository.findByStatus(pageable, status, found);

    }
}
