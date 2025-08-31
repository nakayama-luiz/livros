package com.example.orliv.repository;

import com.example.orliv.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUsername(String name);
}
