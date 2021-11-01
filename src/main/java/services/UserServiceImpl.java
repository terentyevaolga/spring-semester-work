package services;

import forms.SendReviewForm;
import forms.SignInForm;
import forms.SignUpForm;
import models.Review;
import models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.AuthRepository;
import repositories.UsersRepository;

import javax.servlet.http.Cookie;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private UsersRepository usersRepository;
    private AuthRepository authRepository;
    private PasswordEncoder passwordEncoder;


    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.authRepository = authRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public UserServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User signup(SignUpForm signUpForm) {
        User user = new User();
        user.setName(signUpForm.getName());
        user.setEmail(signUpForm.getEmail());

        String passwordHash = passwordEncoder.encode(signUpForm.getPassword());
        user.setPasswordHash(passwordHash);

        return usersRepository.save(user);
    }

    @Override
    public Cookie signin(SignInForm signInForm) {

        User user = usersRepository.findByName(signInForm.getName());

        if (user != null) {
            if (passwordEncoder.matches(signInForm.getPassword(), user.getPasswordHash())) {
                String cookieValue = UUID.randomUUID().toString();
                System.out.println(cookieValue);
                Cookie cookie = new Cookie("auth", cookieValue);
                cookie.setMaxAge(10 * 60 * 60);
                return cookie;
            }
        }
        return null;
    }

    @Override
    public Review sendReview(SendReviewForm sendReviewForm) {
        Review review = new Review();
        review.setUserName(sendReviewForm.getName());
        review.setUserEmail(sendReviewForm.getEmail());
        review.setUserReviewText(sendReviewForm.getReviewText());

        return usersRepository.save(review);
    }
}

