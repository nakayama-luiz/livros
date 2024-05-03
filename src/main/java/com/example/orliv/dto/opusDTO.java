package com.example.orliv.dto;

import com.example.orliv.model.opus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class opusDTO {
    private opus opus;

    private List<Long> author_id;
}
