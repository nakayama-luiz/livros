package com.example.orliv.controller;

import com.example.orliv.domain.Author;
import com.example.orliv.service.AuthorService;
import com.example.orliv.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
public class AuthorController extends GenericCrudController<Author, Long> {
    protected AuthorController(CrudService<Author, Long> service) {
        super(service);
    }

    public void mentir() {
        getService(AuthorService.class).comprar();
    }
}
