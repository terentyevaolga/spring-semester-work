package ru.kpfu.itis.cotrollers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.forms.SendReviewForm;
import ru.kpfu.itis.services.ReviewService;

@Controller
@AllArgsConstructor
public class SendReviewController {

  private final ReviewService reviewService;

  @GetMapping("/review")
  public String getPage() {
    return "review";
  }

  @PostMapping("/review")
  public String doPost(SendReviewForm sendReviewForm) {
    reviewService.sendReview(sendReviewForm);
    return "reviewAfter";
  }
}

