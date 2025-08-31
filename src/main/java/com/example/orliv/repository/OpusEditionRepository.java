package com.example.orliv.repository;

import com.example.orliv.domain.OpusEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OpusEditionRepository extends JpaRepository<OpusEdition, Long> {

}
