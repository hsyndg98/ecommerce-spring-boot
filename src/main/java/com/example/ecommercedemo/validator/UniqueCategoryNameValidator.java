package com.example.ecommercedemo.validator;

import com.example.ecommercedemo.service.CategoryService;
import com.example.ecommercedemo.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCategoryNameValidator implements ConstraintValidator<UniqueCategoryName, String> {

    private final CategoryService categoryService;


    public UniqueCategoryNameValidator(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public boolean isValid(String categoryName, ConstraintValidatorContext constraintValidatorContext) {
        return !categoryService.existsByUserName(categoryName);
    }
}
