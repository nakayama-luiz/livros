package com.example.orliv.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bookcase")
public class bookcases {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_bookcase", sequenceName = "seq_bookcase")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany(mappedBy = "bookcases")
    @JsonBackReference
    private List<edition> editions = new ArrayList<>();

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Blank names are not allowed")
    private String name;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private user owner;

}
