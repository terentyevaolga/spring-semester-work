package ru.kpfu.itis.cotrollers;

import java.util.Optional;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.forms.SignInForm;
import ru.kpfu.itis.forms.SignUpForm;
import ru.kpfu.itis.services.UserService;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService usersService;

    @GetMapping("/signup")
    public String getSignUpPage()  {
        return "index";
    }

    @PostMapping("/signup")
    public String saveUser(SignUpForm signUpForm)  {
        usersService.signup(signUpForm);
        return "redirect:/main";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/signIn")
    public String getSignInPage() {
        return "signin";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signIn")
    protected String signIn(SignInForm signInForm, Model model) {
        Optional<UserDto> userDto = usersService.signin(signInForm);
        if (userDto.isPresent()) {
            return "redirect:/main";
        }
        model.addAttribute("signInStatus", "Неправильный логин или пароль! Повторите попытку!");
        return "signin";
    }
}