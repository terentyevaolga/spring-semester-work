package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.models.Film;

import java.util.Optional;

public interface FilmsRepository extends JpaRepository<Film, Integer> {

  Optional<Film> findByName(String name);
}
