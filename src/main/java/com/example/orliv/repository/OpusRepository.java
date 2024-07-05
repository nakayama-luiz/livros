package com.example.orliv.repository;

import com.example.orliv.model.opus;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OpusRepository extends JpaRepository<opus, Long> {


    @Query(value = "select o.* from opus o inner join opus_author oa on oa.opus_id = o.id inner join author a on a.id = oa.author_id where a.id = ?", nativeQuery = true)
//    @Query("select o.title, o.time from Opus o " +
//        "inner join OpusAuthor oa on oa.opus.id = o.id " +
//        "inner join Author a on a.id = oa.author.id " +
//        "where a.id = ?1")
    List<opus> findAllOpusByAuthor(Long author);

}
