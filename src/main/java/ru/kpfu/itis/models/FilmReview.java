package ru.kpfu.itis.models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FilmReview {
    @Id
    private int id;
    private String userName;
    private String text;
    @OneToOne
    private FilmReview filmId;
}
