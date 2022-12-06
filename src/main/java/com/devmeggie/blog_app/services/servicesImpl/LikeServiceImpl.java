package com.devmeggie.blog_app.services.servicesImpl;

import com.devmeggie.blog_app.exceptions.NotFoundException;
import com.devmeggie.blog_app.models.Like;
import com.devmeggie.blog_app.models.Post;
import com.devmeggie.blog_app.repositories.PostRepo;
import com.devmeggie.blog_app.services.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class LikeServiceImpl implements LikeService {
    private final PostRepo postRepo;

    @Override
    public void likePost(Long postId) {
        Post post = postRepo.findById(postId).orElseThrow(()-> new NotFoundException("post was not found"));

        Like like = Like.builder()
                .post(post)
                .user(null)
                .build();
        post.getLike().add(like);
        postRepo.save(post);
    }

    @Override
    public int noOfLikesOnPost(Long postId) {
        Post post = postRepo.findById(postId)
                .orElseThrow(()-> new NotFoundException("post not found"));

        return post.getLike().size();

    }
}
