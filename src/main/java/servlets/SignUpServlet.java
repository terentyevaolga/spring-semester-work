package servlets;

import models.User;
import repositories.UsersRepository;
import repositories.UsersRepositoryInMemoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    private UsersRepository usersRepository;

    @Override
    public void init() throws ServletException {
        this.usersRepository = new UsersRepositoryInMemoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = usersRepository.findAll();
        request.setAttribute("usersFromServer", users);
        request.getRequestDispatcher("jsp/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // вытащили данные регистрации
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        // создали пользователя и сохранили его в хранилище
        User user = new User(name, password, email);
        usersRepository.save(user);
        //после регистрации оставляем пользователя на этой же странице
//        doGet(req, resp);
        req.getRequestDispatcher("jsp/signup.jsp").forward(req, resp);

    }
}