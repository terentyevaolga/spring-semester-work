package ru.kpfu.itis.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.models.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

  Optional<User> findByName(String name);
}
