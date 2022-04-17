package ru.kpfu.itis.cotrollers;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.dto.FilmRatingDto;
import ru.kpfu.itis.forms.FilmForm;
import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.models.FilmReview;
import ru.kpfu.itis.services.FilmService;

@Controller
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

  @PostMapping("/show_film/{filmName}")
  @PreAuthorize("permitAll()")
  public String saveFilmReview(FilmReview filmReview, @PathVariable("filmName") String filmName) {
    filmService.saveReviewToFilm(filmReview);
    return "redirect:/show_film/" + filmName;
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @PostMapping("/add_film")
  public String saveNewFilm(FilmForm filmForm) {
    filmService.saveFilm(filmForm);
    return "redirect:/films";
  }

  @ResponseBody
  @GetMapping("/films/rating/{page_number}")
  public ResponseEntity<List<FilmRatingDto>> getPage(@PathVariable("page_number") Integer pageNumber) {
    List<FilmRatingDto> films = filmService.getPageFilmByRating(pageNumber);
    return ResponseEntity.ok(films);
  }
}
