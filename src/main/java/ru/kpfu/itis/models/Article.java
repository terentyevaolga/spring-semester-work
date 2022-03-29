package ru.kpfu.itis.models;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    private int id;
    private String title;
    private String description;
}
