package com.example.orliv.repository;

import com.example.orliv.domain.Edition;
import com.example.orliv.dto.EditionResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditionRepository extends JpaRepository<Edition, Long> {

    @Query("""
                select distinct new com.example.orliv.dto.EditionResponseDTO(
                    e.title, p.name, a.name,
                    e.cover, e.ISBN, o.time
                )
                from Edition e
                join e.publisher p
                join OpusEdition oe on oe.edition.id =  e.id
                inner join OpusAuthor oa on oa.opus.id = oe.opus.id
                inner join Author a on a.id = oa.author.id
                inner join Opus o on o.id = oa.opus.id
                where a.id = :authorId
            """)
    List<EditionResponseDTO> findAllByAuthorId(Long authorId);

}
