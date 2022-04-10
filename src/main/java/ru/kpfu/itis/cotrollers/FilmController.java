package ru.kpfu.itis.cotrollers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.forms.FilmForm;
import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.models.FilmReview;
import ru.kpfu.itis.services.FilmService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller("/films")
@AllArgsConstructor
public class FilmController {

  private final FilmService filmService;

  @GetMapping("/show_film/{filmName}")
  @PreAuthorize("permitAll()")
  public String getFilms(@PathVariable("filmName") String filmName, Model model) {
    Film film = filmService.findFilm(filmName);
    model.addAttribute("film", film);
    List<FilmReview> reviews = filmService.getReviews(film);
    model.addAttribute("reviews", reviews);
    return "showFilm";
  }

  // TODO: 10.04.2022 сделать через ajax
  @PostMapping("/show_film/{filmName}")
  @PreAuthorize("permitAll()")
  public String saveFilmReview(FilmReview filmReview, @PathVariable("filmName") String filmName) {
    filmService.saveReviewToFilm(filmReview);
    return "redirect:/show_film/" + filmName;
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @PostMapping("add_film")
  public String saveNewFilm(FilmForm filmForm) {
    filmService.saveFilm(filmForm);
    return "redirect:/films";
  }

  @GetMapping()
  public String getPage(Model model) {
    List<Film> films = filmService.getAll();
    model.addAttribute("films", films);
    return "films";
  }
}
