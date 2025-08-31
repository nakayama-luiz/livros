package com.example.orliv.controller;

import com.example.orliv.domain.OpusEdition;
import com.example.orliv.service.OpusEditionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/opus-edition/")
public class OpusEditionController extends GenericCrudController<OpusEdition, Long> {


    protected OpusEditionController(OpusEditionService service) {
        super(service);
    }

//    @GetMapping("/encontraTudo")
//    public ResponseEntity<List<Map<String, Object>>> compras() {
//        return new ResponseEntity<>(service2.findAll(), HttpStatus.OK);
//    }

}
