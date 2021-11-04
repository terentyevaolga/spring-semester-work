package servlets;

import models.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show_film")
public class ShowFilmServlet extends HttpServlet {

    private Film film;
    
    public ShowFilmServlet(Film film) {
        this.film = film;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("film", film);
        req.getRequestDispatcher("showFilm.jsp").forward(req, resp);
    }
}
