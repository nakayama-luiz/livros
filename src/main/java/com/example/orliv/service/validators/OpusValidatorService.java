package com.example.orliv.service.validators;

import com.example.orliv.domain.Opus;
import com.example.orliv.service.GenericValidatorService;

import java.time.LocalDate;

public class OpusValidatorService implements GenericValidatorService<Opus> {

    @Override
    public void validate(Opus entity) {
        if (entity.getTime() > LocalDate.now().getYear()) {
            throw new RuntimeException("Invalid date.");
        }
    }
}
