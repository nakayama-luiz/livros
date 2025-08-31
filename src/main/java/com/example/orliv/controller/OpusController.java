package com.example.orliv.controller;

import com.example.orliv.domain.Opus;
import com.example.orliv.dto.createOpusDTO;
import com.example.orliv.service.OpusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/opus")
public class OpusController extends GenericCrudController<Opus, Long> {

    private final OpusService opusService;

    protected OpusController(OpusService service) {
        super(service);
        this.opusService = service;
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<Opus>> getOpusByAuthor(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.opusService.findOpusByAuthor(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Opus> createOpus(@RequestBody createOpusDTO opusDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.opusService.createOpus(opusDTO));

    }

}
