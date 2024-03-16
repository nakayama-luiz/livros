package com.example.orliv.model;

import com.example.orliv.model.enums.language;
import jakarta.persistence.*;
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
    @SequenceGenerator(allocationSize = 1, name = "gen_edition", sequenceName = "seq_edition")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "edition_bookcases",
            joinColumns = @JoinColumn(name = "bookcases_id"),
            inverseJoinColumns = @JoinColumn(name = "edition_id")
    )
    private List<bookcases> bookcases;
}
