package ru.kpfu.itis.repositories;


import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.models.FilmReview;

import java.util.List;

public interface FilmReviewRepository {
    List<FilmReview> findAll(Film film);
    FilmReview save(FilmReview filmsReview);
}
