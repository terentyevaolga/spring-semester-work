package ru.kpfu.itis.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.*;
import ru.kpfu.itis.dto.UserDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password_hash")
    private String passwordHash;
    @Column(name = "email")
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToMany()
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<Group> groups = new HashSet<>();

    public enum Role {
        ADMIN, USER
    }

    public UserDto toUserDto() {
        return new UserDto(
                name,
                passwordHash,
                email,
                role
        );
    }
}
