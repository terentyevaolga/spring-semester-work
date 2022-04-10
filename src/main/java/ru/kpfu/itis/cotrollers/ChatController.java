package ru.kpfu.itis.cotrollers;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.dto.MessageDto;
import ru.kpfu.itis.forms.MessageForm;
import ru.kpfu.itis.services.GroupService;

@RestController
@AllArgsConstructor
public class ChatController {

  private final GroupService groupService;

  @MessageMapping("/chat/{group}")
  @SendTo("")
  public MessageDto send(MessageForm message, @PathVariable("group") String group) {
    return groupService.saveChatMessage(message, group);
  }

  @GetMapping("/chat/{group}/messages")
  public ResponseEntity<List<MessageDto>> getMessages(@PathVariable("group") String group) {
      return ResponseEntity.ok(groupService.getLastMessages(group));
  }
}
