package com.devmeggie.blog_app.controllers;

import com.devmeggie.blog_app.dtos.UserLogInDto;
import com.devmeggie.blog_app.dtos.UserSignUpDto;
import com.devmeggie.blog_app.models.User;
import com.devmeggie.blog_app.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody UserSignUpDto userSignUpDto) {
        userService.signUp(userSignUpDto);
        return new ResponseEntity<>("SignUp successfully", HttpStatus.CREATED);
    }

    @PostMapping("/log-In")
    public User logIn(@Validated @RequestBody UserLogInDto userLogInDto) {
        User user = userService.logIn(userLogInDto);
        httpSession.setAttribute("user_id", user.getId());

        return user;
    }

    @GetMapping("/log-out")
    public ResponseEntity<String> logOut() {
        userService.logOut();
        return ResponseEntity.ok(userService.logOut());
    }
    }



