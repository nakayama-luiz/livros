package com.example.orliv.controller;

import com.example.orliv.model.bookcases;
import com.example.orliv.model.enums.Status;
import com.example.orliv.service.BookcaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/bookcase", consumes = "application/json", produces = "application/json")
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

    @PutMapping
    public ResponseEntity<bookcases> update(@RequestBody bookcases estante){
        return ResponseEntity.status(HttpStatus.OK).body(bookcaseService.update(estante));
    }

    @GetMapping("/{id}")
    public ResponseEntity<bookcases> findByid(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(bookcaseService.list(id));
    }

    @GetMapping
    public ResponseEntity<Page<bookcases>> findUserBookcases(@RequestParam Long id, @RequestParam Status status, Pageable pageable){
        return ResponseEntity.status(HttpStatus.FOUND).body(bookcaseService.findUserBookcases(pageable, id,status));
    }

}
