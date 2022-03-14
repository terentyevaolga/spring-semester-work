package ru.kpfu.itis.models;
import lombok.*;
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    private Long id;
    private String userPhone;
    private String userReviewText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserReviewText() {
        return userReviewText;
    }

    public void setUserReviewText(String userReviewText) {
        this.userReviewText = userReviewText;
    }
}
