package com.example.ecommercedemo.repository;

import com.example.ecommercedemo.model.Role;
import com.example.ecommercedemo.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleType name);
}
