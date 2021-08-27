package com.example.ecommercedemo.service;

import com.example.ecommercedemo.model.Role;
import com.example.ecommercedemo.model.RoleType;

import java.util.Optional;

public interface RoleService {
    Role findByName(RoleType name);
}
