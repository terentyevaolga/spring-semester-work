package ru.kpfu.itis.services;

import ru.kpfu.itis.forms.SendReviewForm;
import ru.kpfu.itis.forms.SignInForm;
import ru.kpfu.itis.forms.SignUpForm;
import ru.kpfu.itis.models.Review;
import ru.kpfu.itis.models.User;

import javax.servlet.http.Cookie;

public interface UserService {
    User signup(SignUpForm signUpForm);
    Cookie signin(SignInForm signInForm);
    Review sendReview(SendReviewForm sendReviewForm);
    User findUserByCookieValue(String cookieValue);
}
