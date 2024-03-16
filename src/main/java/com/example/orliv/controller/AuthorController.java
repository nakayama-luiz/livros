package com.example.orliv.controller;

import com.example.orliv.model.author;
import com.example.orliv.service.AuthorService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/{id}")
    public ResponseEntity<author> getAuthorById(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getAuthorById(id));

    }
}
