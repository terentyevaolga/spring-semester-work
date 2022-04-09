package ru.kpfu.itis.models;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Film {
    @Id
    private int id;
    private String name;
    private String trailer;
    private String rating;
    private String year;
    private String director;
    private String image;
    private String description;
}
