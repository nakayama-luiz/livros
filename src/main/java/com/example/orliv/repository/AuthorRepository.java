package com.example.orliv.repository;

import com.example.orliv.model.author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<author, Long> {
}
