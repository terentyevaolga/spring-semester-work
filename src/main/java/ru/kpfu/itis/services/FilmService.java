package ru.kpfu.itis.services;

import ru.kpfu.itis.dto.FilmRatingDto;
import ru.kpfu.itis.forms.FilmForm;
import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.models.FilmReview;

import java.util.List;

public interface FilmService {

  Film findFilm(String name);

  List<FilmReview> getReviews(Film film);

  void saveReviewToFilm(FilmReview filmReview);

  List<Film> getAll();

  List<FilmRatingDto> getPageFilmByRating(int page);

  void saveFilm(FilmForm filmForm);
}
