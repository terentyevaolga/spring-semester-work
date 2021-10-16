package services;

import forms.SignInForm;
import forms.SignUpForm;
import models.User;

import javax.servlet.http.Cookie;

public interface UserService {
    User signup(SignUpForm signUpForm);
    Cookie signin(SignInForm signInForm);
}
