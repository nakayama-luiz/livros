package com.example.orliv.controller;

import com.example.orliv.model.author;
import com.example.orliv.model.opus;
import com.example.orliv.service.OpusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/opus")
@Tag(name = "orvil")
public class OpusController {

    private final OpusService opusService;


    public OpusController(OpusService opusService) {
        this.opusService = opusService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<opus> getOpusById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.opusService.getOpusById(id));
    }


    @GetMapping("/opuses")
    public ResponseEntity<List<opus>> getAllOpus(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.opusService.getAllOpus());
    }

    @PostMapping("/{author_id}")
    public ResponseEntity<opus> createOpus(@RequestBody opus opus, @PathVariable Long author_id){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.opusService.CreateOpus(opus, author_id));

    }

}
