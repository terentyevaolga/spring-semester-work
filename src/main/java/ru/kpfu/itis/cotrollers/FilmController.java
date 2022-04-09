package ru.kpfu.itis.cotrollers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.forms.FilmForm;
import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.models.FilmReview;
import ru.kpfu.itis.services.FilmService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
@AllArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping("/show_film")
    @PreAuthorize("permitAll()")
    public String getFilms(HttpSession session, Model model) {
        Film film = filmService.findFilm((int) session.getAttribute("film"));
        model.addAttribute("film", film);
        List<FilmReview> reviews = filmService.getReviews(film);
        model.addAttribute("reviews", reviews);
        return "show" + film.getName();
    }

    @PostMapping("/show_film")
    @PreAuthorize("permitAll()")
    public String saveFilmReview(FilmReview filmReview) {
        filmService.saveReviewToFilm(filmReview);
        return "redirect:/show_film";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String saveNewFilm(FilmForm filmForm) {
        filmService.saveFilm(filmForm);
        return "redirect:/films";
    }

    @GetMapping("/films")
    public String getPage(Model model) {
        List<Film> films = filmService.getAll();
        model.addAttribute("films", films);
        return "films";
    }

    @PostMapping("/films")
    public String setFilmToSession(HttpSession session, Model model) {
        Integer s =  Integer.valueOf((String) Objects.requireNonNull(model.getAttribute("film")));
        session.setAttribute("film", s);
        return "redirect:/show_film";
    }
}
