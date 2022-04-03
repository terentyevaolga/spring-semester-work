package ru.kpfu.itis.services;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.forms.SendReviewForm;
import ru.kpfu.itis.forms.SignInForm;
import ru.kpfu.itis.forms.SignUpForm;
import ru.kpfu.itis.models.Auth;
import ru.kpfu.itis.models.Review;
import ru.kpfu.itis.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.repositories.AuthRepository;
import ru.kpfu.itis.repositories.UsersRepository;

import javax.servlet.http.Cookie;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UsersRepository usersRepository;
    private AuthRepository authRepository;
    private PasswordEncoder passwordEncoder;


    public UserServiceImpl() {}
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
        review.setUserPhone(sendReviewForm.getPhone());
        review.setUserReviewText(sendReviewForm.getReviewText());

        return usersRepository.save(review);
    }

    @Override
    public User findUserByCookieValue(String cookieValue) {
        Auth auth = authRepository.findByCookieValue(cookieValue);
        if (auth != null) {
            return auth.getUser();
        } else {
            return null;
        }
    }
}

