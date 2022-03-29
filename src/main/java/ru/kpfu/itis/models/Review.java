package ru.kpfu.itis.models;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {
    @Id
    private Long id;
    private String userPhone;
    private String userReviewText;
}
