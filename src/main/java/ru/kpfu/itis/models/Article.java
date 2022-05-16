package ru.kpfu.itis.models;
import javax.persistence.*;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="articles")
public class Article {
    @Id
    @Column(name = "article_id")
    private int id;
    @ManyToOne()
    @JoinTable(
            name = "article_group",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Group group;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
}
