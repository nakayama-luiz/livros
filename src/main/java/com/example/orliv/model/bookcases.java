package com.example.orliv.model;

import jakarta.persistence.*;
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
    private List<edition> editions = new ArrayList<>();

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private user owner;



}
