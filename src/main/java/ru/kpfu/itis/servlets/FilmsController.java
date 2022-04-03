package ru.kpfu.itis.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.services.FilmService;

@Controller("/films")
@AllArgsConstructor
public class FilmsController {

    private final FilmService filmService;

    @GetMapping
    public String getPage(Model model) throws ServletException, IOException {
        List<Film> films = filmService.getAll();
        model.addAttribute("films", films);
        return "films";
    }

    @PostMapping
    public String setFilmToSession(HttpSession session, Model model) {
        Integer s =  Integer.valueOf((String) Objects.requireNonNull(model.getAttribute("film")));
        session.setAttribute("film", s);
       return "redirect:/show_film";
    }
}
