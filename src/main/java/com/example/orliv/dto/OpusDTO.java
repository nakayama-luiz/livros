package com.example.orliv.dto;

import com.example.orliv.domain.enums.Eras;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OpusDTO {
    private Long id;
    private String title;
    private Long time;
    private Eras era;
}
