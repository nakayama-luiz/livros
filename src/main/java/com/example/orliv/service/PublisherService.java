package com.example.orliv.service;

import com.example.orliv.model.publisher;
import com.example.orliv.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public publisher createPublisher(publisher publisher){
        return publisherRepository.save(publisher);
    }
}
