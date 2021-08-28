package com.example.ecommercedemo.dto.request;


import com.example.ecommercedemo.model.CategoryType;
import com.example.ecommercedemo.validator.UniqueCategoryName;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CategoryCreateDTO {

    @UniqueCategoryName
    @NotNull(message = "{backend.constraints.category.NotNull.message}")
    private String name;

    private CategoryType type;

}
