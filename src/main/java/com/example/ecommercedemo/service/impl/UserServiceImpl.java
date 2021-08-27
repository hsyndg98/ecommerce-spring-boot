package com.example.ecommercedemo.service.impl;

import com.example.ecommercedemo.dto.request.UserCreateDTO;
import com.example.ecommercedemo.dto.request.UserUpdateDTO;
import com.example.ecommercedemo.dto.response.UserViewDTO;
import com.example.ecommercedemo.exception.UserNotFoundException;
import com.example.ecommercedemo.model.Role;
import com.example.ecommercedemo.model.RoleType;
import com.example.ecommercedemo.model.User;
import com.example.ecommercedemo.repository.UserRepository;
import com.example.ecommercedemo.service.RoleService;
import com.example.ecommercedemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }


    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserViewDTO getUserByUsername(String username) {
        Objects.requireNonNull(username, "username cannot be null");
        final User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User Not Found Exception"));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> getAllUser() {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserViewDTO createUser(UserCreateDTO user) {
        log.info("createUser is started ");
        Objects.requireNonNull(user, "entity cannot be null");

        Set<Role> roles = new HashSet<>();

        if (user.getRole() == null) {
            Role userRole = roleService.findByName(RoleType.ROLE_USER);
            roles.add(userRole);
        } else {
            Role userRole = roleService.findByName(RoleType.ROLE_ADMIN);
            roles.add(userRole);
        }
        final User user1 = User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .roles(roles)
                .build();
        return UserViewDTO.of(userRepository.save(user1));
    }

    @Override
    @Transactional
    public UserViewDTO updateUser(String username, UserUpdateDTO userUpdateDTO) {
        Objects.requireNonNull(username, "username field cannot be null");
        Objects.requireNonNull(userUpdateDTO, "entity cannot be null");

        final User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));

        user.setUsername(userUpdateDTO.getUsername());
        user.setEmail(userUpdateDTO.getEmail());
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        user.setPassword(userUpdateDTO.getPassword());
        User updateUser = userRepository.save(user);
        return UserViewDTO.of(updateUser);
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        Objects.requireNonNull(username, "username field cannot be null");
        final User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public boolean existsByUserName(String userName) {
        return userRepository.existsByUsername(userName);
    }
}
