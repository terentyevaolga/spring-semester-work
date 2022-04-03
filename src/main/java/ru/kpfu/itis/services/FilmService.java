package ru.kpfu.itis.services;

import java.util.List;

import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.models.FilmReview;

public interface FilmService {

  Film findFilm(Integer id);

  List<FilmReview> getReviews(Film film);

  FilmReview saveReviewToFilm(FilmReview filmReview);

  List<Film> getAll();
}
