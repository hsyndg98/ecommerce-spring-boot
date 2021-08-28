package com.example.ecommercedemo.controller;

import com.example.ecommercedemo.dto.request.CategoryCreateDTO;
import com.example.ecommercedemo.dto.response.CategoryViewDTO;
import com.example.ecommercedemo.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryViewDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<CategoryViewDTO> createCategory(@Valid
                                                          @RequestBody CategoryCreateDTO categoryCreateDTO) {
        return ResponseEntity.ok(categoryService.createCategory(categoryCreateDTO));
    }
}
