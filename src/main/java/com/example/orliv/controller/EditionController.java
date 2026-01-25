package com.example.orliv.controller;

import com.example.orliv.domain.Edition;
import com.example.orliv.dto.EditionRequestDTO;
import com.example.orliv.dto.EditionResponseDTO;
import com.example.orliv.service.CrudService;
import com.example.orliv.service.EditionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/edition")
public class EditionController extends GenericCrudController<Edition, Long> {

    public EditionController(CrudService<Edition, Long> editionService) {
        super(editionService);
    }

    @GetMapping("/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EditionResponseDTO>> findAllEditionByAuthor(@PathVariable Long id) {
        return ResponseEntity.ofNullable(getService(EditionService.class).findAllEditionsByAuthor(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Edition> createEdition(@RequestBody EditionRequestDTO edition) {
        return ResponseEntity.ok().body(getService(EditionService.class).createEdition(edition));
    }
}
