package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Review;
import ru.kpfu.itis.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Long> {
    List<User> findAll(int nothing);
    Iterable<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
    User findByName(String name);
    Review save(Review review);
}
