package com.example.orliv.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "publisher")
public class publisher {
    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_publisher", sequenceName = "seq_publisher")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String description;

    @JsonBackReference
    @OneToMany(mappedBy = "publisher")
    private List<edition> editions;

}