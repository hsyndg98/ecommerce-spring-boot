package com.example.ecommercedemo.model;

import com.example.ecommercedemo.validator.UniqueUserName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "product"})
public class Category extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryType type;

    private String name;

}
