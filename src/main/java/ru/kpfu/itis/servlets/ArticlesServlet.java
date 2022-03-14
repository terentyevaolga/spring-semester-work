package ru.kpfu.itis.servlets;

import ru.kpfu.itis.models.Article;
import ru.kpfu.itis.repositories.ArticlesRepository;
import ru.kpfu.itis.repositories.ArticlesRepositoryImpl;

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

@WebServlet("/main")
public class ArticlesServlet extends HttpServlet {

    private ArticlesRepository articlesRepository;

    private final String DB_URL = "jdbc:postgresql://localhost:5432/DBsemester";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "aser4321";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            articlesRepository = new ArticlesRepositoryImpl(connection);
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articles = articlesRepository.findAll();
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("article");
        req.getSession().setAttribute("article", Integer.valueOf(s));
        resp.sendRedirect("/main");
    }

}
