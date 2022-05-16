package ru.kpfu.itis.security.details;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.repositories.UsersRepository;

@Service
@Primary
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  // интерфейс UserDetailsService нужен для того, чтобы spring security мог получить пользователя

  private final UsersRepository usersRepository;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    return new UserDetailsImpl(usersRepository.findByName(s).orElseThrow(() -> new RuntimeException("User not found")));
  }
}
