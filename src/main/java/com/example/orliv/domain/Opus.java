package com.example.orliv.domain;

import com.example.orliv.domain.enums.Eras;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "opus")
public class Opus {
    @Id
    @SequenceGenerator(allocationSize = 1, name = "opus_seq", sequenceName = "opus_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opus_seq")
    private Long id;

    @NotBlank( message = "Invalid title")
    @Column(name = "title")
    private String title;

    @Column(name = "time")
    @NotNull
    private Long time;

    @Column(name = "era", length = 2)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Eras era;

}
