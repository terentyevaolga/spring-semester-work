package ru.kpfu.itis.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dto.MessageDto;
import ru.kpfu.itis.forms.MessageForm;
import ru.kpfu.itis.mapper.EntityMapper;
import ru.kpfu.itis.models.Group;
import ru.kpfu.itis.models.Message;
import ru.kpfu.itis.repositories.ChatRepository;
import ru.kpfu.itis.repositories.GroupRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

  private final ChatRepository chatRepository;
  private final GroupRepository groupRepository;

  @Override
  public List<Group> getAllGroups() {
    return groupRepository.findAll();
  }

  @Override
  public MessageDto saveChatMessage(MessageForm messageForm, String group) {
    Message message = EntityMapper.map(messageForm, Message.class);
    Date date = new Date();
    message.setDate(date);
    message.setChatGroup(group);
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

  @Override
  public Group getGroup(String name) {
    return groupRepository.findGroupByName(name);
  }
}
