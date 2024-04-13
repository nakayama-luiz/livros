package com.example.orliv.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
@Table(name = "human")
public class user {
    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_user", sequenceName = "seq_user", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String displayName;

    private String password;

    private String username;

    @OneToMany(mappedBy = "owner")
    @JsonBackReference
    private List<bookcases> bookcasesList = new ArrayList<>();

    private String profilePic;

}
