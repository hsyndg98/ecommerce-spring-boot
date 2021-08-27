package com.example.ecommercedemo.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SuperBuilder
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id ;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();
}
