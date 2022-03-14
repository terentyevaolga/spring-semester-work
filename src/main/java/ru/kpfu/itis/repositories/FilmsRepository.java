package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Film;

import java.util.List;

public interface FilmsRepository {
    List<Film> findAll();
    Film findById(int id);
    Film save(Film film);
    void deleteById(int id);
    Film findByName(String name);
}
