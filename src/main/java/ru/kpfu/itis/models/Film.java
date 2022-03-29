package ru.kpfu.itis.models;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Film {
    @Id
    private int id;
    private String name;
    private String imageURL;
    private String description;
}
