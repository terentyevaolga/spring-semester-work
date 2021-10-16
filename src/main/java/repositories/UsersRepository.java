package repositories;

import models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository {
    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
    User findByName(String name);
}
