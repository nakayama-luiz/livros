package com.example.orliv.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_publisher", sequenceName = "seq_publisher")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_publisher")
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String description;

}