package com.example.orliv.repository;

import com.example.orliv.dto.poggersDTO;
import com.example.orliv.model.edition;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface EditionRepository extends JpaRepository<edition, Long> {
//    long countByOpuses_Id(Long id);
//
//    boolean existsByOpuses_Title(String title);
//
//    boolean existsByEditionTitle(String title);
//



    @Query(value = "select e.edition_title as editionTitle, p.name as publisherName, a.name as authorName, e.cover as cover " +
            "from edition e " +
            "inner join editions_opuses eo on eo.edition_id = e.id " +
            "inner join publisher p on p.id = e.publisher_id " +
            "inner join opus o on o.id = eo.opus_id " +
            "inner join opus_author oa on oa.opus_id = o.id " +
            "inner join author a on oa.author_id = a.id " +
            "where a.id = :authorId", nativeQuery = true)
    List<Map<String, Object>> findAllByAuthor(Long authorId);
}
