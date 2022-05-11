package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {

  Optional<User> findByName(String name);

}
