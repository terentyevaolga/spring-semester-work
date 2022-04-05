package ru.kpfu.itis.services;

import ru.kpfu.itis.dto.ReviewDto;
import ru.kpfu.itis.forms.SendReviewForm;

public interface ReviewService {

  public ReviewDto sendReview(SendReviewForm sendReviewForm);
}
