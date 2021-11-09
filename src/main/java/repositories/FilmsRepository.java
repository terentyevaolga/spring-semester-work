package repositories;

import models.Film;
import models.Review;
import models.User;

import java.util.List;
import java.util.Optional;

public interface FilmsRepository {
    List<Film> findAll();
    Film findById(int id);
    Film save(Film film);
    void deleteById(int id);
    Film findByName(String name);
}
