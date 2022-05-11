package ru.kpfu.itis.repositories;


import ru.kpfu.itis.models.Message;

import java.util.List;

public interface ChatRepository {

  Message save(Message message);
  List<Message> getLastMessages(String group, Integer limit);

}
