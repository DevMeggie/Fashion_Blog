package com.devmeggie.blog_app.controllers;

import com.devmeggie.blog_app.dtos.ModifyCategoryDto;
import com.devmeggie.blog_app.models.Category;
import com.devmeggie.blog_app.pagination_criteria.CategoryPage;
import com.devmeggie.blog_app.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    public final CategoryService categoryService;

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "Category created";
    }

    @GetMapping("/viewAllCategory")
    public Page<Category> viewAllCategories(CategoryPage categoryListPages) {
        return categoryService.viewAllCategories(categoryListPages);
    }

    @GetMapping("/{id}")
    public Category viewCategoryById(@PathVariable("id") Long id) {
        return categoryService.viewCategoryById(id);
    }

    @PatchMapping("/modifyCategory/{id}")
    public Category modifyCategory(@PathVariable("id") Long id, @RequestBody ModifyCategoryDto categoryDto) {
        return categoryService.modifyCategory(id, categoryDto);

    }

    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return "category successfully deleted";
    }
}

