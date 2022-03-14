package ru.kpfu.itis.servlets;

import ru.kpfu.itis.models.Film;
import ru.kpfu.itis.models.FilmReview;
import ru.kpfu.itis.repositories.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/show_film")
public class ShowFilmServlet extends HttpServlet {

    private Film film;
    private FilmsRepositoryImpl filmsRepository;
    private FilmReviewRepository filmReviewRepository;

    private final String DB_URL = "jdbc:postgresql://localhost:5432/DBsemester";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "aser4321";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            filmsRepository = new FilmsRepositoryImpl(connection);
            filmReviewRepository = new FilmReviewRepositoryImpl(connection);
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        film = filmsRepository.findById((int) req.getSession().getAttribute("film"));
        req.setAttribute("film", film);
        List<FilmReview> reviews = filmReviewRepository.findAll(film);
        req.setAttribute("reviews", reviews);
        req.getRequestDispatcher("show" + film.getName() + ".jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("review_name");
        String text = req.getParameter("review_text");
        if (userName != null && text != null) {
            FilmReview filmReview = new FilmReview();
            filmReview.setUserName(userName);
            filmReview.setText(text);
            filmReview.setFilmId(film.getId());
            filmReviewRepository.save(filmReview);
            resp.sendRedirect("show_film");
        }
    }
}
