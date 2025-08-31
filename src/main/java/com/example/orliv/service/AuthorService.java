package com.example.orliv.service;

import com.example.orliv.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends GenericCrudService<Author, Long> {

    public AuthorService(CrudRepository<Author, Long> repository) {
        super(repository);
    }

    @Override
    public Author create(Author author) {
        if (author.getVulgos().isEmpty()) {
            author.getVulgos().add(author.getName());
        }

        return this.getCrudRepository().save(author);
    }

    public void comprar() {

    }

}
