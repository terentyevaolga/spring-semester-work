package ru.kpfu.itis.models;
import javax.persistence.*;

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
    @ManyToOne
    private Film film;
}
