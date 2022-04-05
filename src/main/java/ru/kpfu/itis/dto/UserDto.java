package ru.kpfu.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.models.User;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  private String name;
  private String passwordHash;
  private String email;
  private User.Role role;
}
