package com.devmeggie.blog_app.services;

public interface LikeService {
    void likePost(Long postId);

    int noOfLikesOnPost(Long postId);

}
