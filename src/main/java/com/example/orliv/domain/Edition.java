package com.example.orliv.domain;

import com.example.orliv.domain.enums.Language;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.ISBN;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "edition")
public class Edition {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "seq_edition", sequenceName = "seq_edition")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_edition")
    private Long id;

    @ManyToMany
    @NotNull
    @JoinTable(
            name = "editions_opuses",
            joinColumns = @JoinColumn(name = "edition_id"),
            inverseJoinColumns = @JoinColumn(name = "opus_id")
    )
    private List<Opus> opuses = new ArrayList<>();

    @Column(name = "title")
    @NotNull @NotBlank
    private String title;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    @NotNull @NotEmpty
    private List<Language> language;

    @JsonProperty("ISBN")
    @Column(name = "isbn", unique = true)
    @NotBlank
    @NotNull
    @ISBN
    private String ISBN;

    @NotNull
    @Column(name = "pages")
    private Long pages;

    @Column(name = "publication_date")
    @JsonProperty("publication_date")
    @PastOrPresent
    private LocalDate publicationDate;

    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "cover")
    private String cover;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @NotNull
    private Publisher publisher;

}
