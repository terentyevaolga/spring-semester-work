package ru.kpfu.itis.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import ru.kpfu.itis.dto.ReviewDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review")
public class Review {
    @Id
    @Column(name = "review_id")
    private Long id;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "user_review_text")
    private String userReviewText;

    public ReviewDto toReviewDto() {
        return new ReviewDto(
          userPhone,
          userReviewText
        );
    }
}
