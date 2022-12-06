package com.devmeggie.blog_app.services;

import com.devmeggie.blog_app.models.Comment;

import java.util.List;

public interface CommentService {
    String makeComment(Long postId, Comment comment);

    int NoOfComment(Long postId);

    List<Comment> viewPostComment (Long postId);
}
