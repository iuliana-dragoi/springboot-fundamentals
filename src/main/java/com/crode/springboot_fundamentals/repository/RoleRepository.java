package com.crode.springboot_fundamentals.repository;

import com.crode.springboot_fundamentals.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
