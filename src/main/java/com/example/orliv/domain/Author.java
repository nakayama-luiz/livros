package com.example.orliv.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {
    @Id
    @SequenceGenerator(allocationSize = 1, name = "author_seq", sequenceName = "author_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    private Long id;

    @NotBlank(message = "Author must have a name.")
    @Column(name = "name", nullable = false)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> vulgos;

    @Column(name = "biography", columnDefinition = "TEXT")
    private String biography;

    @Column(name = "picture")
    private String picture;
}
