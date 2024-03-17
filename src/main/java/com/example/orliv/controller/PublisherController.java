package com.example.orliv.controller;


import com.example.orliv.model.publisher;
import com.example.orliv.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping
    public ResponseEntity<publisher> createPublisher(@RequestBody publisher publisher){
       return ResponseEntity.status(HttpStatus.CREATED).body(this.publisherService.createPublisher(publisher));
    }
}
