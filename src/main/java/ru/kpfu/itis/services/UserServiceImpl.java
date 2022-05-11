package ru.kpfu.itis.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.forms.SignInForm;
import ru.kpfu.itis.forms.SignUpForm;
import ru.kpfu.itis.mapper.EntityMapper;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UsersRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


  private final UsersRepository usersRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDto signup(SignUpForm signUpForm) {
    User user = EntityMapper.map(signUpForm, User.class);
    String passwordHash = passwordEncoder.encode(signUpForm.getPassword());
    user.setPasswordHash(passwordHash);
    User retUser = usersRepository.save(user);
    return EntityMapper.map(retUser, UserDto.class);
  }

  @Override
  public Optional<UserDto> signin(SignInForm signInForm) {
    Optional<User> user = usersRepository.findByName(signInForm.getName());
    return user.map(entity -> EntityMapper.map(entity, UserDto.class));
  }
}
