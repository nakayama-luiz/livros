package com.example.orliv.service;

import com.example.orliv.domain.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService extends GenericCrudService<Publisher, Long> {

    public PublisherService(CrudRepository<Publisher, Long> repository) {
        super(repository);
    }

}
