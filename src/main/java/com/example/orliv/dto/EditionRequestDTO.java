package com.example.orliv.dto;


import com.example.orliv.domain.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EditionRequestDTO {
    private OpusDTO opus;
    private String editionTitle;
    private List<Language> languages;
    private Long pages;
    private String synopsis;
    private String cover;
    private PublisherDTO publisher;
    private String isbn;
    private LocalDate publicationDate;
}
