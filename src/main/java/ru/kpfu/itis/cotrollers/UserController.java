package ru.kpfu.itis.cotrollers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.forms.SignInForm;
import ru.kpfu.itis.forms.SignUpForm;
import ru.kpfu.itis.services.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService usersService;

    @GetMapping("/signup")
    @PreAuthorize("permitAll()")
    public String getSignUpPage()  {
        return "index";
    }

    @PostMapping("/signup")
    @PreAuthorize("permitAll()")
    public String saveUser(SignUpForm signUpForm)  {
        usersService.signup(signUpForm);
        return "redirect:/main";
    }

    @GetMapping("/signin")
    @PreAuthorize("permitAll()")
    public String getSignInPage() {
        return "signin";
    }

    @PostMapping("/signin")
    @PreAuthorize("permitAll()")
    protected String signIn(SignInForm signInForm, HttpServletResponse resp, Model model) {
        Optional<UserDto> userDto = usersService.signin(signInForm);
        if (userDto.isPresent()) {
            return "redirect:/main";
        }
        model.addAttribute("signInStatus", "Неправильный логин или пароль! Повторите попытку!");
        return "signin";
    }
}