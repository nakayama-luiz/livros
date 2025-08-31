package com.example.orliv.domain;

import com.example.orliv.domain.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.math.NumberUtils;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookcase")
public class Bookcases {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "gen_bookcase", sequenceName = "seq_bookcase")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bookcase")
    private Long id;

    @NotBlank(message = "Blank names are not allowed")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @Column(name = "favorite")
    private Boolean favorite = Boolean.FALSE;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "start_date")
    private LocalDate start;

    @Column(name = "end_date")
    private LocalDate end;

    @OneToMany(mappedBy = "bookcase")
    private List<ReadingHistory> readingHistory;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "editions_id")
    private Edition editions;

    @Column(name = "read_pages")
    private Long readPages = NumberUtils.LONG_ZERO;


}
