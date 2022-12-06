package com.devmeggie.blog_app.repositories;

import com.devmeggie.blog_app.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Optional<Category> findCategoriesById(Long id);

    boolean existsByName(String category);
}
