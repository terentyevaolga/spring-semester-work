package ru.kpfu.itis.cotrollers;

import java.security.Principal;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kpfu.itis.models.Group;
import ru.kpfu.itis.services.GroupService;

@AllArgsConstructor
@Controller
public class GroupController {

  private final GroupService groupService;

  public void createGroup(){}

  public void joinToGroup(){}

  @GetMapping("/groups")
  public String seeAllGroups(Model model){
    List<Group> groupList = groupService.getAllGroups();
    model.addAttribute("groups", groupList);
    return "groups";
  }

  @GetMapping("/chat/{group}")
  public String getChatPage(@PathVariable("group") String group, Model model, Principal principal) {
    Group groupEntity = groupService.getGroup(group);
    model.addAttribute("group", groupEntity);
    model.addAttribute("userName", principal.getName());
    return "chat";
  }

  @GetMapping("/groups/{group}")
  public String seeGroup(@PathVariable("group") String group, Model model){
    Group groupEntity = groupService.getGroup(group);
    model.addAttribute("group", groupEntity);
    return "group";
  }
}
