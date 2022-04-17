package ru.kpfu.itis.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "chat_message")
public class Message {

  @Id
  private Integer id;
  private String text;
  private String writer;
  private String chatGroup;
  private Date date;
}
