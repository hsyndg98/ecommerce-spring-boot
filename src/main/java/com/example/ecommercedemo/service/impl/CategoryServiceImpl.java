package com.example.ecommercedemo.service.impl;

import com.example.ecommercedemo.dto.request.CategoryCreateDTO;
import com.example.ecommercedemo.dto.response.CategoryViewDTO;
import com.example.ecommercedemo.model.Category;
import com.example.ecommercedemo.repository.CategoryRepository;
import com.example.ecommercedemo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryViewDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryViewDTO::of).collect(Collectors.toList());
    }

    @Override
    public CategoryViewDTO createCategory(CategoryCreateDTO categoryCreate) {
        Objects.requireNonNull(categoryCreate, "entity cannot be null");
        final Category category = Category.builder()
                .name(categoryCreate.getName())
                .type(categoryCreate.getType())
                .build();
        return CategoryViewDTO.of(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(CategoryViewDTO categoryViewDTO) {

    }

    @Override
    public boolean existsByUserName(String categoryName) {
        return false;
    }
}
