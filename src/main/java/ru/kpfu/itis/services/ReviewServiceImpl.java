package ru.kpfu.itis.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dto.ReviewDto;
import ru.kpfu.itis.forms.SendReviewForm;
import ru.kpfu.itis.mapper.EntityMapper;
import ru.kpfu.itis.models.Review;
import ru.kpfu.itis.repositories.ReviewRepository;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

  private final ReviewRepository reviewRepository;

  @Override
  public ReviewDto sendReview(SendReviewForm sendReviewForm) {
    Review review = EntityMapper.map(sendReviewForm, Review.class);
    Review retReview =  reviewRepository.save(review);
    return EntityMapper.map(retReview, ReviewDto.class);
  }
}

