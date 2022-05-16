package ru.kpfu.itis.cotrollers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.forms.SendReviewForm;
import ru.kpfu.itis.services.ReviewService;
import ru.kpfu.itis.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor

public class SendReviewController {

  @Autowired
  private ReviewService reviewService;

  @GetMapping("/contact")
  public String getContactPage() {
    return "contact";
  }

  @GetMapping("/review")
  public String getPage() {
    return "review";
  }

  @PostMapping("/review")
  public String doPost(HttpServletRequest req) {
    SendReviewForm sendReviewForm = new SendReviewForm(
            req.getParameter("phone"),
            req.getParameter("comment")
    );
    reviewService.sendReview(sendReviewForm);
    return "contact";
  }
}

