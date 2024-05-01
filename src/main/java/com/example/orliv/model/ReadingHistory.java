package com.example.orliv.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class ReadingHistory {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_history", sequenceName = "seq_history")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)public Long id;

    private LocalDate date;

    private Long pages;

    @ManyToOne
    @JoinColumn(name = "bookcases_id")
    public bookcases bookcase;


}
