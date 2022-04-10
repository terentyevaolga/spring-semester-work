package ru.kpfu.itis.services;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.forms.FilmForm;
import ru.kpfu.itis.helper.FileHelper;
import ru.kpfu.itis.mapper.EntityMapper;
import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.models.FilmReview;
import ru.kpfu.itis.repositories.FilmReviewRepository;
import ru.kpfu.itis.repositories.FilmsRepository;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {

  private final FilmsRepository filmsRepository;
  private final FilmReviewRepository filmReviewRepository;
  private final FileHelper fileHelper;

  @Override
  public Film findFilm(String name) {
    return filmsRepository.findByName(name).orElseThrow(() -> new RuntimeException("Can't find film with this id"));
  }

  @Override
  public List<FilmReview> getReviews(Film film) {
    return filmReviewRepository.findByFilm(film);
  }

  public void saveReviewToFilm(FilmReview filmReview) {
    filmReviewRepository.save(filmReview);
  }

  @Override
  public List<Film> getAll() {
    return filmsRepository.findAll();
  }

  @Override
  @SneakyThrows
  public void saveFilm(FilmForm filmForm) {
    String avatar = fileHelper.saveFile(filmForm.getIcon().getBytes());
    Film film = EntityMapper.map(filmForm, Film.class);
    film.setImage(avatar);
    filmsRepository.save(film);
  }
}
