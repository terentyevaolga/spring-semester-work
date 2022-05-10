package ru.kpfu.itis.services;

import ru.kpfu.itis.dto.MessageDto;
import ru.kpfu.itis.forms.MessageForm;
import ru.kpfu.itis.models.Group;

import java.util.List;

public interface GroupService {

  public List<Group> getAllGroups();

  MessageDto saveChatMessage(MessageForm messageForm, String group);

  List<MessageDto> getLastMessages(String group);

  Group getGroup(String name);
}
