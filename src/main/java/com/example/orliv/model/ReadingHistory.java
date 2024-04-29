package com.example.orliv.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ReadingHistory {

    @Id
    public Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "bookcases_id")
    public bookcases bookcase;


}
