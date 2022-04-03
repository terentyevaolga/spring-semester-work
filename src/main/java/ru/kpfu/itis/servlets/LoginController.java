package ru.kpfu.itis.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.forms.SignInForm;
import ru.kpfu.itis.services.UserService;

@Controller("/signin")
@AllArgsConstructor
public class LoginController {

  private final UserService userService;

  @GetMapping
  public String getPage() {
    return "signin";
  }

  @PostMapping
  protected String doPost(SignInForm signInForm, HttpServletResponse resp, Model model) {
    Cookie cookie = userService.signin(signInForm);
    if (cookie != null) {
      resp.addCookie(cookie);
      return "redirect:/main";
    }
    model.addAttribute("signInStatus", "Неправильный логин или пароль! Повторите попытку!");
    return "signin";
  }
}
