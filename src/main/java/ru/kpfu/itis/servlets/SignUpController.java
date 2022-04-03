package ru.kpfu.itis.servlets;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.forms.SignUpForm;
import ru.kpfu.itis.services.UserService;

@Controller("/signup")
@AllArgsConstructor
public class SignUpController {

    private final UserService usersService;

    @GetMapping
    public String getPage()  {
        return "index";
    }

    @PostMapping
    public String saveUser(SignUpForm signUpForm)  {
        usersService.signup(signUpForm);
        return "redirect:/main";
    }
}