package com.devmeggie.blog_app.services.servicesImpl;

import com.devmeggie.blog_app.dtos.ModifyCategoryDto;
import com.devmeggie.blog_app.enums.Role;
import com.devmeggie.blog_app.exceptions.AlreadyExistException;
import com.devmeggie.blog_app.exceptions.NotFoundException;
import com.devmeggie.blog_app.exceptions.UnauthorizedException;
import com.devmeggie.blog_app.models.Category;
import com.devmeggie.blog_app.models.User;
import com.devmeggie.blog_app.pagination_criteria.CategoryPage;
import com.devmeggie.blog_app.repositories.CategoryRepo;
import com.devmeggie.blog_app.services.CategoryService;
import com.devmeggie.blog_app.services.UserService;
import com.devmeggie.blog_app.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    public final HttpSession httpSession;
    public final UserService userService;
    public final CategoryRepo categoryRepo;
    public final Util util;

    @Override
    public void createCategory(Category category) {
        Long userId = util.loggedInUserById();
        User user = util.findUserById(userId);

        if (!user.getRole().equals(Role.ADMIN)) {
            throw new UnauthorizedException("Oops! Admin only");
        }
        if (categoryRepo.existsByName(category.getName())) {
            throw new AlreadyExistException("this category already exist");
        }
        Category category1 = Category.builder()
                .name(category.getName())
                .build();
        categoryRepo.save(category1);

    }

    @Override
    public Page<Category> viewAllCategories(CategoryPage categoryPage) {
        List<Category> categoryList = categoryRepo.findAll();
        if (categoryList.isEmpty()) {
            throw new NotFoundException("There are no categories yet");
        }
        Sort sort = Sort.by(categoryPage.getSortDirection(), categoryPage.getSortBy());
        Pageable pageable = PageRequest.of(categoryPage.getPageNumber(), categoryPage.getPageSize(), sort);

        return categoryRepo.findAll(pageable);

    }

    @Override
    public Category viewCategoryById(Long id) {
        return categoryRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Category was not found"));

    }

    @Override
    public Category modifyCategory(Long id, ModifyCategoryDto modifyCategoryDto) {
        Long userId = util.loggedInUserById();
        User user = util.findUserById(userId);


        if (!user.getRole().equals(Role.ADMIN)) {
            throw new UnauthorizedException("Only admins can upload post");
        }
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Category was not found"));
        if(modifyCategoryDto.getName()!=null)
            category.setName(modifyCategoryDto.getName());
        return categoryRepo.save(category);

    }

    @Override
    public void deleteCategory(Long id) {
        Long userId = util.loggedInUserById();
        User user = util.findUserById(userId);

        if (!user.getRole().equals(Role.ADMIN)){
            throw new UnauthorizedException("Only admins can delete post");
        }

        Category category = categoryRepo.findCategoriesById(id)
                .orElseThrow(() -> new NotFoundException("category not found"));

        categoryRepo.delete(category);
    }
}

