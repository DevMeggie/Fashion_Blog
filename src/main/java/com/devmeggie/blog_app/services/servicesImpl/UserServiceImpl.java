package com.devmeggie.blog_app.services.servicesImpl;

import com.devmeggie.blog_app.dtos.UserLogInDto;
import com.devmeggie.blog_app.dtos.UserSignUpDto;
import com.devmeggie.blog_app.enums.Gender;
import com.devmeggie.blog_app.enums.Role;
import com.devmeggie.blog_app.exceptions.AlreadyExistException;
import com.devmeggie.blog_app.exceptions.NotFoundException;
import com.devmeggie.blog_app.models.User;
import com.devmeggie.blog_app.repositories.UserRepo;
import com.devmeggie.blog_app.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final HttpSession httpSession;

    @Override
    public User signUp(UserSignUpDto userSignUpDto) {
        String userEmail = userSignUpDto.getEmail();
        boolean users = userRepo.existsByEmail(userEmail);
        if (users) {
            throw new AlreadyExistException("user Already Exist");
        }
        User user = new User();
        user.setEmail(userSignUpDto.getEmail());
        user.setFirstName(userSignUpDto.getFirstName());
        user.setLastName(userSignUpDto.getLastName());
        user.setPassword(userSignUpDto.getPassword());
        user.setRole(Role.ADMIN);
        user.setGender(Gender.MALE);
        user.setPost(new ArrayList<>());
        userRepo.save(user);
        return user;
    }

    @Override
    public User logIn(UserLogInDto userLoginDto) {

        String email = userLoginDto.getEmail();
        String password = userLoginDto.getPassword();
        User user = userRepo.findByEmailAndPassword(email, password);
        if (user != null) {
            return user;
        } else {
            throw new NotFoundException("user not found");
        }
    }

    @Override
    public String logOut() {
        httpSession.invalidate();
        return "user Logged Out";
    }


}