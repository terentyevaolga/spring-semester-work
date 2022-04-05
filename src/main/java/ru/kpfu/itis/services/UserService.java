package ru.kpfu.itis.services;

import java.util.Optional;

import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.forms.SendReviewForm;
import ru.kpfu.itis.forms.SignInForm;
import ru.kpfu.itis.forms.SignUpForm;
import ru.kpfu.itis.models.Review;
import ru.kpfu.itis.models.User;

import javax.servlet.http.Cookie;

public interface UserService {
    UserDto signup(SignUpForm signUpForm);
    Optional<UserDto> signin(SignInForm signInForm);
}
