package com.example.orliv.repository;

import com.example.orliv.domain.Edition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface EditionRepository extends JpaRepository<Edition, Long> {

    @Query(value = """
            select distinct e.edition_title as editionTitle, p.name as publisherName, a.name as authorName, e.cover as cover,el."language", e.isbn
            from edition e
                inner join editions_opuses eo on eo.edition_id = e.id
                inner join publisher p on p.id = e.publisher_id
                inner join opus o on o.id = eo.opus_id
                inner join opus_author oa on oa.opus_id = o.id
                inner join author a on oa.author_id = a.id
                left join edition_language el on el.edition_id = e.id
            where a.id = :authorId
            """, nativeQuery = true)
    List<Map<String, Object>> findAllByAuthorId(Long authorId);

    @Query("select e from edition e inner join e.publisher p where p.id :publisherId")
    List<Edition> findAllByPublisher(@Param("publisherId") Long publisherId);

}
