package com.example.orliv.service;

import com.example.orliv.domain.Author;
import com.example.orliv.domain.Opus;
import com.example.orliv.domain.OpusAuthor;
import com.example.orliv.dto.createOpusDTO;
import com.example.orliv.repository.AuthorRepository;
import com.example.orliv.repository.OpusAuthorRepository;
import com.example.orliv.repository.OpusRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OpusService extends GenericCrudService<Opus, Long> {
    private final AuthorRepository authorRepository;
    private final OpusAuthorRepository opusAuthorRepository;

    public OpusService(OpusRepository repository, AuthorRepository authorRepository,
                       OpusAuthorRepository opusAuthorRepository) {
        super(repository);
        this.authorRepository = authorRepository;
        this.opusAuthorRepository = opusAuthorRepository;
    }

    public List<Opus> findOpusByAuthor(Long authorId) {
        return getRepository(OpusRepository.class).findAllOpusByAuthor(authorId);
    }

    public Opus createOpus(createOpusDTO opusDTO) {
        Opus opus = opusDTO.getOpus();
        List<Long> authorsIds = opusDTO.getAuthorsIds();

        if (opus.getTime() > LocalDate.now().getYear()) {
            throw new RuntimeException("Invalid date.");
        }

        final Set<Author> authors = authorRepository.findAllToSetById(authorsIds);

        if (authors.isEmpty()) {
            throw new EntityNotFoundException("None authors were found.");
        }

        Opus saved = getRepository(OpusRepository.class).save(opus);

        opusAuthorRepository.saveAll(authors.stream()
                .map(author -> new OpusAuthor(opus, author))
                .collect(Collectors.toSet()));

        return saved;
    }

}
