package ru.kpfu.itis.cotrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("error")
public class ErrorController {

  @GetMapping
  public String errorPage() {
    return "error";
  }
}
