package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.models.FilmReview;

import java.util.List;

public interface FilmsRepository extends JpaRepository<Film, Integer> {
}
