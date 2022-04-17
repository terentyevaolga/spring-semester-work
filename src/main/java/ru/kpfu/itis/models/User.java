package ru.kpfu.itis.models;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="users")
public class User {
    @Id
    private Long id;
    private String name;
    private String passwordHash;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToMany(mappedBy = "users")
    private Set<Group> groups = new HashSet<>();

    public enum Role {
        ADMIN, USER
    }
}
