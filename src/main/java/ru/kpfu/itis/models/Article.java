package ru.kpfu.itis.models;
import javax.persistence.*;

import lombok.*;
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
