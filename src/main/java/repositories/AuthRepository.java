package repositories;

import models.Auth;
import models.User;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;
import java.util.Optional;

public interface AuthRepository extends PasswordEncoder {
    Auth findByCookieValue(String cookieValue);
    List<Auth> findAll();
    Optional<Auth> findById(Long id);
    User save(Auth auth);
    void deleteById(Long id);
}


