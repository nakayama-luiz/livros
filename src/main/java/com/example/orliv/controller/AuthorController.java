package com.example.orliv.controller;

import com.example.orliv.model.author;
import com.example.orliv.model.opus;
import com.example.orliv.service.AuthorService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/{id}")
    public ResponseEntity<author> getAuthorById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getAuthorById(id));

    }

    @PostMapping
    public ResponseEntity<author> createAuthor(@RequestBody author author){
            return ResponseEntity.status(HttpStatus.CREATED).body(authorService.createAuthor(author));
    }

    @PutMapping
    public ResponseEntity<author> upateAuthor(@RequestBody author author){
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.updateAuthor(author));
    }
}
