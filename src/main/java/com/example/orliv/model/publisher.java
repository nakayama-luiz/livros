package com.example.orliv.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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

    private String name;

    private String description;

    @JsonBackReference
    @OneToMany(mappedBy = "publisher")
    private List<edition> editions;

}
