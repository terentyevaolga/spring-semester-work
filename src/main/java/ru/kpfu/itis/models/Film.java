package ru.kpfu.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

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
