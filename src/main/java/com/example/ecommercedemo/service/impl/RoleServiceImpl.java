package com.example.ecommercedemo.service.impl;

import com.example.ecommercedemo.exception.RoleNotFoundException;
import com.example.ecommercedemo.model.Role;
import com.example.ecommercedemo.model.RoleType;
import com.example.ecommercedemo.repository.RoleRepository;
import com.example.ecommercedemo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(RoleType name) {
        Objects.requireNonNull(name, "name cannot be null");
        return roleRepository.findByName(name).orElseThrow(() -> new RoleNotFoundException("Role Not Found"));
    }
}
