package com.devmeggie.blog_app.services.servicesImpl;

import com.devmeggie.blog_app.exceptions.NotFoundException;
import com.devmeggie.blog_app.models.Comment;
import com.devmeggie.blog_app.models.Post;
import com.devmeggie.blog_app.repositories.CommentRepo;
import com.devmeggie.blog_app.repositories.PostRepo;
import com.devmeggie.blog_app.services.CommentService;
import com.devmeggie.blog_app.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServeImpl implements CommentService {

    private final CommentRepo commentRepo;
    private final Util util;
    private final PostRepo postRepo;

    @Override
    public String makeComment(Long postId, Comment comment) {
            Post post = postRepo.findById(postId).orElseThrow(() -> new NotFoundException("this post doesnt exist"));

            Comment comment1 = Comment.builder()
                    .comment(comment.getComment())
                    .post(post)
                    .userId(null)
                    .build();
            commentRepo.save(comment1);
            post.getComment().add(comment1);
            postRepo.save(post);



        return "comment saved";
    }

    @Override
    public int NoOfComment(Long postId) {
        Post post = postRepo.findById(postId).orElseThrow(()-> new NotFoundException("post not found"));

        return post.getComment().size();

    }

    @Override
    public List<Comment> viewPostComment(Long postId) {
        Post post = postRepo.findById(postId).orElseThrow(()-> new NotFoundException("post not found"));
        return post.getComment();
    }

    }

