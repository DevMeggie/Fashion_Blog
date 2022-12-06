package com.devmeggie.blog_app.services;

import com.devmeggie.blog_app.dtos.UserLogInDto;
import com.devmeggie.blog_app.dtos.UserSignUpDto;
import com.devmeggie.blog_app.models.User;

public interface UserService {
    User signUp(UserSignUpDto userSignUpDto);

    User logIn(UserLogInDto userLoginDto);

    String logOut();

}
