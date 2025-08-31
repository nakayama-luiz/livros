package com.example.orliv.dto;

import com.example.orliv.domain.Edition;
import com.example.orliv.domain.Opus;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class createEditionDTO {
    private Edition edition;

    private Opus opus;
}
