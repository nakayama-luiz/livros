package com.example.orliv.domain;

import com.example.orliv.domain.enums.Language;
import com.example.orliv.dto.EditionRequestDTO;
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
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Column(name = "title")
    @NotNull @NotBlank
    private String title;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.LAZY)
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

    public Edition(EditionRequestDTO requestDTO) {
        if (Objects.isNull(requestDTO)) return;

        this.title = requestDTO.getEditionTitle();
        this.language = requestDTO.getLanguages();
        this.ISBN = requestDTO.getIsbn();
        this.pages = requestDTO.getPages();
        this.publicationDate = requestDTO.getPublicationDate();
        this.synopsis = requestDTO.getSynopsis();
        this.cover = requestDTO.getCover();
        this.publisher = Optional.ofNullable(requestDTO.getPublisher())
                .map(p -> new Publisher(p.getId(), p.getName(), p.getDescription()))
                .orElse(new Publisher());
    }
}
