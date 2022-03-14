package ru.kpfu.itis.servlets;

import ru.kpfu.itis.forms.SignUpForm;
import ru.kpfu.itis.repositories.UsersRepository;
import ru.kpfu.itis.repositories.UsersRepositoryImpl;
import ru.kpfu.itis.services.UserService;
import ru.kpfu.itis.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    private UserService usersService;

    private final String DB_URL = "jdbc:postgresql://localhost:5432/DBsemester";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "aser4321";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            UsersRepository usersRepository = new UsersRepositoryImpl(connection);
            usersService = new UserServiceImpl(usersRepository);
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        SignUpForm signUpForm = new SignUpForm();
        signUpForm.setName(req.getParameter("name"));
        signUpForm.setEmail(req.getParameter("email"));
        signUpForm.setPassword(req.getParameter("password"));

        usersService.signup(signUpForm);

//        req.getRequestDispatcher("/jsp/signup.jsp").forward(req, resp);
        resp.sendRedirect("/main");
    }
}