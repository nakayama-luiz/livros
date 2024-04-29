package com.example.orliv.controller;

import com.example.orliv.model.edition;
import com.example.orliv.model.opus;
import com.example.orliv.service.EditionService;
import com.example.orliv.service.OpusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/edition")
public class EditionController {

    private final EditionService editionService;

    private final OpusService opusService;

    public EditionController(EditionService editionService, OpusService opusService) {
        this.editionService = editionService;
        this.opusService = opusService;
    }


    @PostMapping
    public ResponseEntity<edition> aVoid(@RequestBody edition edition){

        return ResponseEntity.status(HttpStatus.CREATED).body(this.editionService.createEdition(edition));

    }

    @GetMapping
    public ResponseEntity<List<edition>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.editionService.all());
    }
}
