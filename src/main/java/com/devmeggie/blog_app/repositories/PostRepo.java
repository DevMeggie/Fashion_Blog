package com.devmeggie.blog_app.repositories;

import com.devmeggie.blog_app.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {



}
