package com.devmeggie.blog_app.services;

import com.devmeggie.blog_app.dtos.ModifyCategoryDto;
import com.devmeggie.blog_app.models.Category;
import com.devmeggie.blog_app.pagination_criteria.CategoryPage;
import org.springframework.data.domain.Page;

public interface CategoryService  {
    void createCategory(Category category);

    Page<Category> viewAllCategories(CategoryPage categoryPage);

    Category viewCategoryById(Long id);

    Category modifyCategory(Long id, ModifyCategoryDto categoryDto);

    void deleteCategory(Long id);
}
