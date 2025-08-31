package com.example.orliv.service.validators;

import com.example.orliv.domain.Opus;
import com.example.orliv.service.GenericValidatorService;

public class OpusValidatorService implements GenericValidatorService<Opus> {

    @Override
    public void validate(Opus entity) {
        GenericValidatorService.super.validate(entity);
    }
}
