package com.example.orliv.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class ReadingHistory {

    @Id
    @SequenceGenerator(name = "gen_history", sequenceName = "seq_history", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_history")
    public Long id;

    @NotNull
    private LocalDate date;

    @NotNull
    private Long pages;

    @ManyToOne
    @JoinColumn(name = "bookcases_id")
    @NotNull
    public Bookcases bookcase;

}
