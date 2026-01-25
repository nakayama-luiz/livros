package com.example.orliv.repository;

import com.example.orliv.domain.ReadingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<ReadingHistory, Long> {
}
