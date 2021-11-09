package services;

import forms.SendReviewForm;
import forms.SignInForm;
import forms.SignUpForm;
import models.Review;
import models.User;

import javax.servlet.http.Cookie;

public interface UserService {
    User signup(SignUpForm signUpForm);
    Cookie signin(SignInForm signInForm);
    Review sendReview(SendReviewForm sendReviewForm);
    User findUserByCookieValue(String cookieValue);
}
