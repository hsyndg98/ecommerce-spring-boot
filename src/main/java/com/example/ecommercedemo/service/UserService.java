package com.example.ecommercedemo.service;

import com.example.ecommercedemo.dto.request.UserCreateDTO;
import com.example.ecommercedemo.dto.request.UserUpdateDTO;
import com.example.ecommercedemo.dto.response.UserViewDTO;

import java.util.List;

public interface UserService {

    UserViewDTO getUserByUsername(String username);
    List<UserViewDTO> getAllUser();
    UserViewDTO createUser(UserCreateDTO user);
    UserViewDTO updateUser(String username, UserUpdateDTO userUpdateDTO);
    void deleteUser(String username);
    boolean existsByUserName(String userName);
}
