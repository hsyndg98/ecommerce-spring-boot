package com.example.ecommercedemo.dto.response;

import com.example.ecommercedemo.model.Category;
import com.example.ecommercedemo.model.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryViewDTO implements Serializable {

    private final static long serialVersionUID = 1L;

    private String name;
    private CategoryType type;

    public static CategoryViewDTO of(Category category) {
        return CategoryViewDTO.builder()
                .name(category.getName())
                .type(category.getType())
                .build();
    }
}
