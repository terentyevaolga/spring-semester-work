package ru.kpfu.itis.cotrollers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.dto.MessageDto;
import ru.kpfu.itis.forms.MessageForm;
import ru.kpfu.itis.services.GroupService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ChatController {


  private final SimpMessagingTemplate messagingTemplate;
  private final GroupService groupService;

  @MessageMapping("/chat/{group}")
  public void send(MessageForm message, @PathVariable("group") String group) {
    MessageDto messageDto =  groupService.saveChatMessage(message, group);
    messagingTemplate.convertAndSend("/chat/" + group + "/messages", messageDto);
  }

  @GetMapping("/chat/last/{group}")
  public ResponseEntity<List<MessageDto>> getMessages(@PathVariable("group") String group) {
      return ResponseEntity.ok(groupService.getLastMessages(group));
  }
}
