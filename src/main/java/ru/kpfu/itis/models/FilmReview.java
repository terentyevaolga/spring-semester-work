package ru.kpfu.itis.models;
import javax.persistence.*;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "film_review")
public class FilmReview {
    @Id
    @Column(name = "film_review_id")
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinTable(
            name = "film_review_film",
            joinColumns = @JoinColumn(name = "film_review_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private Film film;
}
