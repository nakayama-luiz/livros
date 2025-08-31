package com.example.orliv.controller;

import com.example.orliv.domain.Edition;
import com.example.orliv.service.EditionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/edition")
public class EditionController extends GenericCrudController<Edition, Long> {

    private final EditionService editionService;

    public EditionController(EditionService editionService) {
        super(editionService);
        this.editionService = editionService;
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<Map<String, Object>>> findAllEditionByAuthor(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.editionService.findAllEditionsByAuthor(id));
    }
}
