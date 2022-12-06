package com.devmeggie.blog_app.controllers;

import com.devmeggie.blog_app.services.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/{id}")
    public String likePost(@PathVariable("id") Long postId) {
        likeService.likePost(postId);
        return "post liked";
    }

    @GetMapping("/noOfLikes/{id}")
    public int noOfLikesOnPost(@PathVariable("id") Long postId){
        return likeService.noOfLikesOnPost(postId);
    }
}