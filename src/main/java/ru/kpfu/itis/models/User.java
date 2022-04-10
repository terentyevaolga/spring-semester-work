package ru.kpfu.itis.models;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String passwordHash;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, USER
    }
}
