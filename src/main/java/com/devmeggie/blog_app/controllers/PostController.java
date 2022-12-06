package com.devmeggie.blog_app.controllers;

import com.devmeggie.blog_app.dtos.ModifyPostDto;
import com.devmeggie.blog_app.dtos.UpLoadPostDto;
import com.devmeggie.blog_app.dtos.ViewPostDto;
import com.devmeggie.blog_app.models.Post;
import com.devmeggie.blog_app.pagination_criteria.PostPage;
import com.devmeggie.blog_app.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postservice;


    @PostMapping("/{id}")
    public Post uploadPost(@PathVariable("id") Long categoryId, @RequestBody UpLoadPostDto uploadPostDto) {
        return postservice.uploadPost(uploadPostDto, categoryId);

    }

    @GetMapping("/viewAllPost")
    public Page<Post> viewAllPost(PostPage postPage) {
        return postservice.viewAllPost(postPage);
    }

    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable("postId") Long postId) {
        postservice.deletePost(postId);
        return "post deleted successfully";
    }

    @GetMapping("/{id}")
    public Post viewPostById(@PathVariable ("id")Long postId){

        return postservice.viewPostById(postId);
    }

    @PostMapping("/modifyPost/{id}")
    public Post modifyPost(@PathVariable("id") Long id,ModifyPostDto post){
         return postservice.modifyPost(id,post);

    }
    @GetMapping("/postByCategoryId/{categoryId}")
    public List<ViewPostDto> viewPostByCategoryId(@PathVariable("categoryId") Long categoryId){
        return postservice.viewPostByCategory(categoryId);
    }
}



