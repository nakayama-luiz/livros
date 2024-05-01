package com.example.orliv.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.orliv.model.enums.eras;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class opus {
    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_opus", sequenceName = "seq_opus")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank( message = "Invalid title")
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "time", nullable = false)
    //@NotBlank( message = "Invalid date")
    @NotNull
    private Long time;

    @Column(name = "era", nullable = false, length = 2, columnDefinition = "DC")
    @Enumerated(EnumType.STRING)
    private eras era = eras.AC;

    @ManyToMany(mappedBy = "opus")
    @NotNull
    private List<author> author = new ArrayList<>();

    @ManyToMany(mappedBy = "opuses")
    @JsonBackReference
    private List<edition> editions = new ArrayList<>();

}
