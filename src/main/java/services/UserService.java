package services;

import form.SignInForm;
import form.SignUpForm;
import models.User;

import javax.servlet.http.Cookie;

public interface UserService {
    User signup(SignUpForm signUpForm);
    Cookie signin(SignInForm signInForm);
}
