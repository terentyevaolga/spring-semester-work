package ru.kpfu.itis.models;

import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="groups")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group {

  @Id
  @Column(name = "group_id")
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "description")
  private String description;
  @OneToMany()
  private List<Article> articles;
  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "user_group",
      joinColumns = { @JoinColumn(name = "group_id") },
      inverseJoinColumns = { @JoinColumn(name = "user_id") }
  )
  private List<User> users;
}
