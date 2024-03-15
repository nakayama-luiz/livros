package com.example.orliv.model;

import com.example.orliv.model.enums.language;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class edition {

    private Long id;

    private List<opus> opuses;

    private String editionTitle;

    private List<language> languages;

    private String ISBN;

    private Integer pages;

    private LocalDate publicationDate;

    private String synopisis;

    private String cover;


}
