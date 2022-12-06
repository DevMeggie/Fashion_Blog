package com.devmeggie.blog_app.services;

import com.devmeggie.blog_app.dtos.ModifyPostDto;
import com.devmeggie.blog_app.dtos.UpLoadPostDto;
import com.devmeggie.blog_app.dtos.ViewPostDto;
import com.devmeggie.blog_app.models.Post;
import com.devmeggie.blog_app.pagination_criteria.PostPage;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService  {
    Post uploadPost(UpLoadPostDto upLoadPostDto, Long category);

    Page<Post>viewAllPost(PostPage postPage);

    void deletePost(Long postId);

    Post viewPostById(Long postId);

    Post modifyPost( Long id, ModifyPostDto post);

    List<ViewPostDto> viewPostByCategory(Long categoryId);

}
