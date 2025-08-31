package com.example.orliv.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "opus_edition")
@Getter
@Setter
@NoArgsConstructor
public class OpusEdition {

    @Id
    @SequenceGenerator(allocationSize = 1, sequenceName = "opus_edition_seq", name = "opus_edition_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opus_edition_seq")
    private Long id;


    @JoinColumn(name = "edition_id")
    @ManyToOne
    private Edition edition;

    @JoinColumn(name = "opus_id")
    @ManyToOne
    private Opus opus;
    
}
