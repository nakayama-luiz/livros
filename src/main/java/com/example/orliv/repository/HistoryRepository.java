package com.example.orliv.repository;

import com.example.orliv.domain.ReadingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<ReadingHistory, Long> {
}
