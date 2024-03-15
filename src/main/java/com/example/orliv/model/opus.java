package com.example.orliv.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class opus {
    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_opus", sequenceName = "seq_opus")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @NotBlank( message = "Invalid title")
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "time", nullable = false)
    @NotBlank( message = "Invalid date")
    private Long time;

    @NotBlank(message = "Invalid era")
    @Column(name = "era", nullable = false)
    private Character era;

    @ManyToMany(mappedBy = "opus")
    private List<author> author = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "edition_opuses",
            joinColumns = @JoinColumn(name = "edition_id"),
            inverseJoinColumns = @JoinColumn(name = "opuses_id")
    )
    private List<edition> editions;

}
