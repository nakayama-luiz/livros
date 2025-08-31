package com.example.orliv.repository;

import com.example.orliv.domain.OpusAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OpusAuthorRepository extends JpaRepository<OpusAuthor, Long> {
}
