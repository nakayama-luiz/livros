package com.example.orliv.repository;

import com.example.orliv.model.bookcases;
import com.example.orliv.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookcaseRepository extends JpaRepository<bookcases, Long> {

    List<bookcases> findAllByOwner(user owner);
}
