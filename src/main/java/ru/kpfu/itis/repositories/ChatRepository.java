package ru.kpfu.itis.repositories;


import java.util.List;

import ru.kpfu.itis.models.Message;

public interface ChatRepository {

  Message save(Message message);
  List<Message> getLastMessages(String group, Integer limit);
}
