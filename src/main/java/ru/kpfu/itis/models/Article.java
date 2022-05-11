package ru.kpfu.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Group group;
    private String title;
    private String description;

}
