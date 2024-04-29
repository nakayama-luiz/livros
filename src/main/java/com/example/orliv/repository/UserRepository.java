package com.example.orliv.repository;

import com.example.orliv.model.user;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<user, Long> {

    List<user> findAllByUsername(String name);
}
