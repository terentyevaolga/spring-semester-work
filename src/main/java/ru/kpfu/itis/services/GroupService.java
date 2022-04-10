package ru.kpfu.itis.services;

import java.util.List;

import ru.kpfu.itis.dto.MessageDto;
import ru.kpfu.itis.forms.MessageForm;

public interface GroupService {

  MessageDto saveChatMessage(MessageForm messageForm, String group);

  List<MessageDto> getLastMessages(String group);
}
