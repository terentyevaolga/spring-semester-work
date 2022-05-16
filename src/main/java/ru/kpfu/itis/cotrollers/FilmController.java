package ru.kpfu.itis.cotrollers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dto.FilmRatingDto;
import ru.kpfu.itis.forms.FilmForm;
import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.models.FilmReview;
import ru.kpfu.itis.services.FilmService;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@Log
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
  public String saveFilmReview(HttpServletRequest req, @PathVariable("filmName") String filmName) {
    FilmReview filmReview = FilmReview.builder()
                    .id(new Random().nextInt(3000))
                            .text(req.getParameter("review_text"))
                                    .userName(req.getParameter("review_name"))
            .film(filmService.findFilm(filmName))
                                            .build();
    filmService.saveReviewToFilm(filmReview);
    return "redirect:/show_film/" + filmName;
  }

  @PreAuthorize("permitAll()")
 @GetMapping("/add_film")
 public String getSavePage() {
    return "createFilm";
 }

  @PreAuthorize("permitAll()")
  @PostMapping("/add_film")
  public String saveNewFilm(FilmForm filmForm) {
      log.info(filmForm.getName());
    filmService.saveFilm(filmForm);
    return "redirect:/films";
  }

  @ResponseBody
  @GetMapping("/films/rating/{page_number}")
  public ResponseEntity<List<FilmRatingDto>> getPage(@PathVariable("page_number") Integer pageNumber) {
    List<FilmRatingDto> films = filmService.getPageFilmByRating(pageNumber);
    return ResponseEntity.ok(films);
  }

  @GetMapping("/films")
  public ModelAndView filmsPage (HttpServletRequest request) throws UnsupportedEncodingException {
    request.setCharacterEncoding("UTF-8");
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("films", filmService.getAll());
    modelAndView.setViewName("films");
    return modelAndView;
  }

  @PostMapping("/films")
  public String showFilmPage (HttpServletRequest req) {
    String name = req.getParameter("film");
    return "redirect:/show_film/" + name;
  }

  @GetMapping("/rating")
  public String filmsRatingPage () {
    return "rating";
  }

}
