package com.example.orliv.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "author")
public class author {
    @Id
    @SequenceGenerator(allocationSize = 1, name = "seq_aut")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotEmpty(message = "Author must have a name.")
    @NotBlank(message = "Author must have a name.")
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    // @NotBlank(message = "Not valid vulgo")
    // @Column(name = "vulgos")
    @ElementCollection
    private Set<String> vulgos = new HashSet<>();

    @Column(nullable = false, name = "opuses")
    @ManyToMany
    @JsonBackReference
    @JoinTable(
            name = "opus_author",
            joinColumns = @JoinColumn(name = "opus_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<opus> opus = new ArrayList<>();

    @Column(name = "biography")
    private String biography;
}
