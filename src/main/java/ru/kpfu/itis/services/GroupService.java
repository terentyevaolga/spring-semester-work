package ru.kpfu.itis.services;

import java.util.List;

import ru.kpfu.itis.dto.MessageDto;
import ru.kpfu.itis.forms.MessageForm;
import ru.kpfu.itis.models.Group;

public interface GroupService {

  public List<Group> getAllGroups();

  MessageDto saveChatMessage(MessageForm messageForm, String group);

  List<MessageDto> getLastMessages(String group);

  Group getGroup(String name);
}
