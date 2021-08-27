package com.example.ecommercedemo.dto.response;

import com.example.ecommercedemo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserViewDTO implements Serializable {

    private final static long serialVersionUID = 1L;

    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public static UserViewDTO of(User user) {
        return UserViewDTO
                .builder()
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

}
