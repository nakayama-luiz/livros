package com.example.orliv.repository;

import com.example.orliv.model.edition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditionRepository extends JpaRepository<edition, Long> {
    long countByOpuses_Id(Long id);

    boolean existsByOpuses_Title(String title);

    boolean existsByEditionTitle(String title);
}
