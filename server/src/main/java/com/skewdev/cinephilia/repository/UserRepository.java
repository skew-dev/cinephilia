package com.skewdev.cinephilia.repository;

import com.skewdev.cinephilia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
}
