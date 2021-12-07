package com.skewdev.cinephilia.repository;

import com.skewdev.cinephilia.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);	
}