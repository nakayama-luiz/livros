package com.example.orliv.model;

import com.example.orliv.model.enums.language;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "edition")
public class edition {

    @Id
    private Long id;

    @ManyToMany(mappedBy = "editions")
    private List<opus> opuses;

    private String editionTitle;

    private List<language> languages;

    private String ISBN;

    private Integer pages;

    private LocalDate publicationDate;

    private String synopisis;

    private String cover;


}
