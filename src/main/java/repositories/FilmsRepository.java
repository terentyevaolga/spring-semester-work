package repositories;

import models.Film;
import models.Review;
import models.User;

import java.util.List;
import java.util.Optional;

public interface FilmsRepository {
    List<Film> findAll();
    Optional<Film> findById(Long id);
    Film save(Film film);
    void deleteById(Long id);
    Film findByName(String name);
}
