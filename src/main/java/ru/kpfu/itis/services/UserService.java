package ru.kpfu.itis.services;

import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.forms.SignInForm;
import ru.kpfu.itis.forms.SignUpForm;

import java.util.Optional;

public interface UserService {
    UserDto signup(SignUpForm signUpForm);
    Optional<UserDto> signin(SignInForm signInForm);
}
