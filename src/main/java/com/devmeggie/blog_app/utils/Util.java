package com.devmeggie.blog_app.utils;

import com.devmeggie.blog_app.exceptions.NotFoundException;
import com.devmeggie.blog_app.exceptions.UnauthorizedException;
import com.devmeggie.blog_app.models.User;
import com.devmeggie.blog_app.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class Util {
    private final HttpSession httpSession;

    private final UserRepo userRepo;

    public User findUserById(Long id){
        return userRepo.findById(id).orElseThrow(()->new NotFoundException("user not found"));
    }

    public Long loggedInUserById(){
        Long userId = (Long) httpSession.getAttribute("user_id");
        if(userId == null) throw new UnauthorizedException("Please log in!");
        return userId;
    }
}
