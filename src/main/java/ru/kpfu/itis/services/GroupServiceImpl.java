package ru.kpfu.itis.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dto.MessageDto;
import ru.kpfu.itis.forms.MessageForm;
import ru.kpfu.itis.mapper.EntityMapper;
import ru.kpfu.itis.models.Message;
import ru.kpfu.itis.repositories.ChatRepository;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

  private final ChatRepository chatRepository;

  @Override
  public MessageDto saveChatMessage(MessageForm messageForm, String group) {
    Message message = EntityMapper.map(messageForm, Message.class);
    Date date = new Date();
    message.setDate(date);
    message.setGroup(group);
    MessageDto messageDto = EntityMapper.map(chatRepository.save(message), MessageDto.class);
    messageDto.setTime(new SimpleDateFormat("dd.MM.yy HH:mm").format(date));
    return messageDto;
  }

  public List<MessageDto> getLastMessages(String group) {
    return chatRepository.getLastMessages(group, 50)
        .stream()
        .map(entity -> EntityMapper.map(entity, MessageDto.class))
        .collect(
            Collectors.toList());
  }
}
