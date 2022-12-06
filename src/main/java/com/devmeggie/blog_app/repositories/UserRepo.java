package com.devmeggie.blog_app.repositories;

import com.devmeggie.blog_app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    User findByEmailAndPassword(String email, String password);



}
