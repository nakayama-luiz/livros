package com.example.orliv.controller;

import com.example.orliv.model.edition;
import com.example.orliv.model.opus;
import com.example.orliv.service.EditionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/edition",produces = "application/json;charset=UTF-8")
public class EditionController {

    private final EditionService editionService;

    public EditionController(EditionService editionService) {
        this.editionService = editionService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<edition> aVoid(@RequestBody edition edition){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.editionService.createEdition(edition));

    }

    @GetMapping
    public ResponseEntity<List<edition>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.editionService.all());
    }
}
