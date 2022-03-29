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
public class Auth {
    @Id
    private Long id;
    @OneToOne(mappedBy = "id")
    private User user;
    private String cookieValue;
}
