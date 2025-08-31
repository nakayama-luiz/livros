package com.example.orliv.dto;

import com.example.orliv.domain.Opus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class createOpusDTO {
    private Opus opus;
    private List<Long> authorsIds;
}
