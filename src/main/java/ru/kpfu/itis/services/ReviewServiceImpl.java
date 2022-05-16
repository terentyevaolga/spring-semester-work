package ru.kpfu.itis.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dto.ReviewDto;
import ru.kpfu.itis.forms.SendReviewForm;
import ru.kpfu.itis.mapper.EntityMapper;
import ru.kpfu.itis.models.Review;
import ru.kpfu.itis.repositories.ReviewRepository;

import java.util.Random;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

  @Autowired
  private final ReviewRepository reviewRepository;

  @Override
  public ReviewDto sendReview(SendReviewForm sendReviewForm) {
    Review review = EntityMapper.map(sendReviewForm, Review.class);
    review.setId(new Random().nextLong());
    reviewRepository.save(review);
    return review.toReviewDto();
  }
}

