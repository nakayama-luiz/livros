package com.example.orliv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EditionResponseDTO implements Serializable {
    private String editionTitle;
    private String publisherName;
    private String authorName;
    private String cover;
    private String isbn;
    private Long originYear;
}
