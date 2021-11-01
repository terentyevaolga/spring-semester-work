package servlets;

import forms.SendReviewForm;
import repositories.AuthRepository;
import repositories.AuthRepositoryImpl;
import repositories.UsersRepository;
import repositories.UsersRepositoryImpl;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/sendReview")
public class SendReviewServlet extends HttpServlet {

    private UserService userService;

    private final String DB_URL = "jdbc:postgresql://localhost:5432/DBsemester";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "aser4321";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            UsersRepository usersRepository = new UsersRepositoryImpl(connection);
            userService = new UserServiceImpl(usersRepository);
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/review.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        SendReviewForm sendReviewForm = new SendReviewForm();
        sendReviewForm.setName(req.getParameter("name"));
        sendReviewForm.setEmail(req.getParameter("email"));
        sendReviewForm.setReviewText(req.getParameter("reviewText"));

        userService.sendReview(sendReviewForm);
        req.getRequestDispatcher("/jsp/review.jsp").forward(req, resp);
    }
}
