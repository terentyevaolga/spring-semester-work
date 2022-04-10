package ru.kpfu.itis.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Message {

  @Id
  private Integer id;
  private String text;
  private String from;
  private String group;
  private Date date;
}
