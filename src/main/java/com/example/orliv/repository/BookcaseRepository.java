package com.example.orliv.repository;

import com.example.orliv.domain.Bookcases;
import com.example.orliv.domain.User;
import com.example.orliv.domain.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookcaseRepository extends JpaRepository<Bookcases, Long> {

    @Query(value = "select b from Bookcases b where b.owner = :owner")
    List<Bookcases> findAllByOwner(User owner);

    @Query("select b from Bookcases b where b.status = :status and b.owner = :owener")
    Page<Bookcases> findByStatus(Pageable pageable, Status status, User owener);
}
