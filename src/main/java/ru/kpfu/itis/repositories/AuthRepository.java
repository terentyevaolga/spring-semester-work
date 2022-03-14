package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Auth;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;
import java.util.Optional;

public interface AuthRepository extends PasswordEncoder {
    Auth findByCookieValue(String cookieValue);
    List<Auth> findAll();
    Optional<Auth> findById(Long id);
    Auth save(Auth auth);
    void deleteById(Long id);
}


