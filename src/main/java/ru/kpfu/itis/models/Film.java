package ru.kpfu.itis.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.forms.FilmForm;

import java.io.File;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "films")
public class Film {
    @Id
    @Column(name = "film_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "trailer")
    private String trailer;
    @Column(name = "rating")
    private String rating;
    @Column(name = "year")
    private String year;
    @Column(name = "director")
    private String director;
    @Column(name = "image")
    private String image;
    @Column(name = "description")
    private String description;

}
