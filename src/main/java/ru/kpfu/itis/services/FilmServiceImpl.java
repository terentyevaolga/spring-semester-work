package ru.kpfu.itis.services;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dto.FilmRatingDto;
import ru.kpfu.itis.forms.FilmForm;
import ru.kpfu.itis.helper.FileHelper;
import ru.kpfu.itis.mapper.EntityMapper;
import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.models.FilmReview;
import ru.kpfu.itis.repositories.FilmReviewRepository;
import ru.kpfu.itis.repositories.FilmsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {

  private final FilmsRepository filmsRepository;
  private final FilmReviewRepository filmReviewRepository;
  private final FileHelper fileHelper;

  @Override
  public Film findFilm(String name) {
    return filmsRepository.findByName(name)
        .orElseThrow(() -> new RuntimeException("Can't find film with this id"));
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
  public List<FilmRatingDto> getPageFilmByRating(int page) {
    return filmsRepository.findAll(
            PageRequest.of(page, 5, Sort.Direction.ASC, "rating"))
        .stream()
        .map(film -> EntityMapper.map(film,
            FilmRatingDto.class
        ))
        .collect(Collectors.toList());
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
