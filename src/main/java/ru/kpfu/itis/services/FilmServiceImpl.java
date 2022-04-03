package ru.kpfu.itis.services;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.models.FilmReview;
import ru.kpfu.itis.repositories.FilmReviewRepository;
import ru.kpfu.itis.repositories.FilmsRepository;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {

  private final FilmsRepository filmsRepository;
  private final FilmReviewRepository filmReviewRepository;

  @Override
  public Film findFilm(Integer id) {
    return filmsRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't find film with this id"));
  }

  @Override
  public List<FilmReview> getReviews(Film film) {
    return filmReviewRepository.findByFilm(film);
  }

  public FilmReview saveReviewToFilm(FilmReview filmReview) {
    return filmReviewRepository.save(filmReview);
  }

  @Override
  public List<Film> getAll() {
    return filmsRepository.findAll();
  }
}
