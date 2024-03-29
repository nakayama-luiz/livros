package com.example.orliv.controller;

import com.example.orliv.model.bookcases;
import com.example.orliv.service.BookcaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookcase")
public class BookcaseController {

    private final BookcaseService bookcaseService;

    public BookcaseController(BookcaseService bookcaseService) {
        this.bookcaseService = bookcaseService;
    }

    @PostMapping("/{user_id}")
    public ResponseEntity<bookcases> createBookcase(@RequestBody bookcases bookcases, @PathVariable Long user_id){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookcaseService.createBookcase(bookcases, user_id));

    }

    @PutMapping("/edition/{edition_id}")
    public ResponseEntity<bookcases> addEdtion(@RequestBody bookcases bookcases, @PathVariable Long edition_id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookcaseService.addEdtion(bookcases, edition_id));

    }

}
