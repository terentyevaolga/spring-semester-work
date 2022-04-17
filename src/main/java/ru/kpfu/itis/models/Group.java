package ru.kpfu.itis.models;

import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="community")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group {

  @Id
  private int id;
  private String name;
  private String description;
  @OneToMany()
  private List<Article> articles;
  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "Group_User",
      joinColumns = { @JoinColumn(name = "group_id") },
      inverseJoinColumns = { @JoinColumn(name = "user_id") }
  )
  private List<User> users;
}
