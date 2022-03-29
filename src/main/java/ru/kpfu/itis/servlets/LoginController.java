package ru.kpfu.itis.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.forms.SignInForm;
import ru.kpfu.itis.services.UserService;

@Controller("/signin")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String doGet() {
        return "signin";
    }

    @PostMapping
    protected void doPost(SignInForm signInForm, HttpServletResponse resp, HttpServletRequest req)
        throws IOException, ServletException {
        Cookie cookie = userService.signin(signInForm);

        if (cookie != null) {
            resp.addCookie(cookie);
            resp.sendRedirect("main");
        } else {
            req.setAttribute("signInStatus", "Неправильный логин или пароль! Повторите попытку!");
            req.getRequestDispatcher("signin.jsp").forward(req, resp);
        }
    }
}
