package com.example.orliv.repository;

import com.example.orliv.model.opus;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpusRepository extends JpaRepository<opus, Long> {


}
