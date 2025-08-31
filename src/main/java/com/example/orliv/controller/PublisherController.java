package com.example.orliv.controller;


import com.example.orliv.domain.Publisher;
import com.example.orliv.service.PublisherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController extends GenericCrudController<Publisher, Long> {

    public PublisherController(PublisherService publisherService) {
        super(publisherService);
    }

    public void mentiras() {
        getService(PublisherService.class).comprar();
    }

}
