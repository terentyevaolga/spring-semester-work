package ru.kpfu.itis.models;

import java.util.Date;
import javax.persistence.Column;
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
  @Column(name = "chat_message_id")
  private Integer id;
  @Column(name = "text")
  private String text;
  @Column(name = "writer")
  private String writer;
  @Column(name = "chat_group")
  private String chatGroup;
  @Column(name = "date")
  private Date date;
}
