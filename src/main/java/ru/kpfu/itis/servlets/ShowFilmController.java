package ru.kpfu.itis.servlets;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.models.FilmReview;
import ru.kpfu.itis.services.FilmService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("/show_film")
@AllArgsConstructor
public class ShowFilmController {

    private final FilmService filmService;

    @GetMapping
    public String getFilms(HttpSession session, Model model) {
        Film film = filmService.findFilm((int) session.getAttribute("film"));
        model.addAttribute("film", film);
        List<FilmReview> reviews = filmService.getReviews(film);
        model.addAttribute("reviews", reviews);
        return "show" + film.getName();
    }

    @PostMapping
    public String saveFilmReview(FilmReview filmReview) {
        filmService.saveReviewToFilm(filmReview);
        return "redirect:/show_film";
    }
}
