package com.example.ecommercedemo.controller;

import com.example.ecommercedemo.dto.request.UserCreateDTO;
import com.example.ecommercedemo.dto.request.UserUpdateDTO;
import com.example.ecommercedemo.dto.response.UserViewDTO;
import com.example.ecommercedemo.helper.GenericResponse;
import com.example.ecommercedemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserViewDTO> getUserByUsername(@PathVariable String username) {
        log.debug("api/v1/user/{} start for get info", username);
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserViewDTO>> getAllUser() {
        log.debug("api/v1/user/all start");
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping
    public ResponseEntity<UserViewDTO> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        log.info("api/v1/user start for create");

        return ResponseEntity.ok(userService.createUser(userCreateDTO));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        log.debug("api/v1/user/{} start for delete", username);
        userService.deleteUser(username);
        return ResponseEntity.ok(new GenericResponse("User deleted!"));
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserViewDTO> updateUser(@Valid @PathVariable String username,
                                                  @RequestBody UserUpdateDTO userUpdateDTO) {
        log.debug("api/v1/user/{} start for update", username);
        return ResponseEntity.ok(userService.updateUser(username, userUpdateDTO));
    }
}
