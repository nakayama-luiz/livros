package com.example.orliv.dto;

import com.example.orliv.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AuthorDTO implements Serializable {
    private String name;
    private Set<String> vulgos;
    private String picture;
    private String biography;

    public AuthorDTO(Author author) {
        this.name = author.getName();
        this.vulgos = author.getVulgos();
        this.picture = author.getPicture();
        this.biography = Optional.ofNullable(author.getBiography()).orElse(Strings.EMPTY);
    }

}
