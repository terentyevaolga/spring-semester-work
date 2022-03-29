package ru.kpfu.itis.servlets;

import ru.kpfu.itis.forms.SendReviewForm;
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

@WebServlet("/sendReview")
public class SendReviewServlet extends HttpServlet {

    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("review.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        SendReviewForm sendReviewForm = new SendReviewForm();
        sendReviewForm.setPhone(req.getParameter("phone"));
        sendReviewForm.setReviewText(req.getParameter("comment"));

        userService.sendReview(sendReviewForm);
        req.getRequestDispatcher("reviewAfter.jsp").forward(req, resp);
    }
}

