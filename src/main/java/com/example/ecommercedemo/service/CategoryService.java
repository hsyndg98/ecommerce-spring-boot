package com.example.ecommercedemo.service;

import com.example.ecommercedemo.dto.request.CategoryCreateDTO;
import com.example.ecommercedemo.dto.response.CategoryViewDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryViewDTO> getAllCategories();

    CategoryViewDTO createCategory(CategoryCreateDTO categoryCreate);

    void deleteCategory(CategoryViewDTO categoryViewDTO);

    boolean existsByUserName(String categoryName);
}
