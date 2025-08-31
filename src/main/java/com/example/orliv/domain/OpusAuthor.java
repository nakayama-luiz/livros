package com.example.orliv.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "opus_author")
public class OpusAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opus_author_seq")
    @SequenceGenerator(allocationSize = 1, sequenceName = "opus_author_seq", name = "opus_author_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "opus_id")
    private Opus opus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public OpusAuthor(Opus opus, Author author) {
        this.opus = opus;
        this.author = author;
    }

}
