package com.devmeggie.blog_app.controllers;

import com.devmeggie.blog_app.models.Comment;
import com.devmeggie.blog_app.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/{id}")
    public String makeComment(@PathVariable("id") Long postId, @RequestBody Comment comment){
        return commentService.makeComment(postId,comment);
    }

    @GetMapping("/noOfComments/{id}")
    public int noOfComment(@PathVariable ("id")Long postId ){
        return commentService.NoOfComment(postId);
    }

    @GetMapping("/viewPostComment/{id}")
    public List<Comment> viewPostComment(@PathVariable("id") Long postId){
        return commentService.viewPostComment(postId);
    }
}
