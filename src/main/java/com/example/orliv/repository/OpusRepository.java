package com.example.orliv.repository;

import com.example.orliv.domain.Opus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OpusRepository extends JpaRepository<Opus, Long> {

    @Query("SELECT o FROM Opus o " +
            " INNER JOIN OpusAuthor oa on oa.opus = o" +
            " INNER JOIN oa.author a" +
            " WHERE a.id = :author_id")
    List<Opus> findAllOpusByAuthor(@Param("author_id") Long author_id);

}
