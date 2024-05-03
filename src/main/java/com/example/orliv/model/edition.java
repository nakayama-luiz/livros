package com.example.orliv.model;

import com.example.orliv.model.enums.language;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.annotation.Before;
import org.hibernate.validator.constraints.ISBN;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "edition")
public class edition {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_edition", sequenceName = "seq_edition", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany
    @NotNull
    @JoinTable(
            name = "editions_opuses",
            joinColumns = @JoinColumn(name = "edition_id"),
            inverseJoinColumns = @JoinColumn(name = "opus_id")
    )
    private List<opus> opuses = new ArrayList<>();

    @Column(name = "edition_title")
    @NotNull @NotBlank
    @JsonProperty("edition_title")
    private String editionTitle;


    @Enumerated(EnumType.STRING)
    @ElementCollection
    @NotNull
    private List<language> language;

    @Column(name = "isbn") @NotBlank @NotNull
    @JsonProperty("ISBN")
    @ISBN
    private String ISBN;

    @NotNull
    @Column(name = "pages")
    private Integer pages;

    @Column(name = "publication_date")
    @JsonProperty("publication_date")
    @PastOrPresent
    private LocalDate publicationDate;


    @Column(name = "synopisis")
    private String synopisis;

    @Column(name = "cover")
    private String cover;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @NotNull
    private publisher publisher;

    @OneToMany(mappedBy = "editions")
    @JsonBackReference
    private List<bookcases> bookcase = new ArrayList<>();



}
