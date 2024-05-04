package com.example.orliv.repository;

import com.example.orliv.model.bookcases;
import com.example.orliv.model.enums.Status;
import com.example.orliv.model.user;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookcaseRepository extends JpaRepository<bookcases, Long> {

    @Query(value = "select b from bookcases b where b.owner = :owner")
    List<bookcases> findAllByOwner(user owner);

    @Query("select b from bookcases b where b.status = :status and b.owner = :owener")
    Page<bookcases> findByStatus(Pageable pageable, Status status, user owener);
}
