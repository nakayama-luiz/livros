package com.example.orliv.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "human")
public class user {
    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_user", sequenceName = "seq_user")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String displayName;

    private String password;

    private String username;

    @OneToMany(mappedBy = "owner")
    private List<bookcases> bookcasesList = new ArrayList<>();

    private String profilePic;

}
