package com.example.orliv.model;

import com.example.orliv.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookcase")
public class bookcases {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_bookcase", sequenceName = "seq_bookcase")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany(mappedBy = "bookcases")
    private List<edition> editions = new ArrayList<>();

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Blank names are not allowed")
    private String name;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private user owner;

    @Column(nullable = true)
    private Boolean favorite;

    @Column(nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public bookcases(String favoritos, user user) {
        this.name= favoritos;
        this.owner=user;

    }
}
