package ru.kpfu.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
