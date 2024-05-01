package com.example.orliv.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

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

    @Column(name = "username", unique = true)
    @NotBlank
    @NotNull
    @Length(min = 3)
    private String username;

    @OneToMany(mappedBy = "owner")
    //@JsonBackReference
    private List<bookcases> bookcasesList = new ArrayList<>();

    private String profilePic;


}
