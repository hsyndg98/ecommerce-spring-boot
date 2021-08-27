package com.example.ecommercedemo.dto.request;

import com.example.ecommercedemo.validator.UniqueUserName;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class UserCreateDTO {

    @NotNull(message = "{backend.constraints.username.NotNull.message}")
    @Size(min = 3, max = 32, message = "{backend.constraints.username.Size.message}")
    @UniqueUserName
    private String username;

    @NotNull(message = "{backend.constraints.password.NotNull.message}")
    private String password;

    @NotNull(message = "{backend.constraints.firstName.NotNull.message}")
    @Size(min = 3, max = 32, message = "{backend.constraints.firstName.Size.message}")
    private String firstName;

    @NotNull(message = "{backend.constraints.lastName.NotNull.message}")
    @Size(min = 2, max = 32, message = "{backend.constraints.lastName.Size.message}")
    private String lastName;

    @Email
    @NotNull(message = "{backend.constraints.email.NotNull.message}")
    private String email;

    private Set<String> role;
}
