package ru.kpfu.itis.services;

import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.forms.SignInForm;
import ru.kpfu.itis.forms.SignUpForm;
import ru.kpfu.itis.mapper.EntityMapper;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UsersRepository;
import ru.kpfu.itis.security.auth.CookieAuth;
import ru.kpfu.itis.security.details.UserDetailsImpl;

import javax.servlet.http.Cookie;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserDetailsService userDetailsService;
  private final UsersRepository usersRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDto signup(SignUpForm signUpForm) {
    User user = EntityMapper.map(signUpForm, User.class);
    user.setId(1L);
    String passwordHash = passwordEncoder.encode(signUpForm.getPassword());
    user.setPasswordHash(passwordHash);
    User retUser = usersRepository.save(user);
    load(user.getName());
    return EntityMapper.map(retUser, UserDto.class);
  }

  @Override
  public Optional<UserDto> signin(SignInForm signInForm) {
    UserDto user = usersRepository.findByName(signInForm.getName()).get().toUserDto();
    load(user.getName());
    return Optional.of(user);
  }

  private void load(String username) {
    Cookie cookie = new Cookie("Auth", username);
    cookie.setMaxAge(24 * 60 * 60);

    UserDetails userDetails = userDetailsService.loadUserByUsername(username);

    CookieAuth cookieAuthentication = new CookieAuth(cookie.getValue());
    cookieAuthentication.setUserDetails((UserDetailsImpl) userDetails);
    cookieAuthentication.setAuthenticated(true);

    SecurityContextHolder.getContext().setAuthentication(cookieAuthentication);
  }
}
