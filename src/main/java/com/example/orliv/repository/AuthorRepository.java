package com.example.orliv.repository;

import com.example.orliv.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a from Author a where a.id in (:ids)")
    Set<Author> findAllToSetById(List<Long> ids);

}
