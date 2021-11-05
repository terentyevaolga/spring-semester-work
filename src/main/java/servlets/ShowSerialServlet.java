package servlets;

import models.Serial;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show_serial")
public class ShowSerialServlet extends HttpServlet {

    private Serial serial;

    public ShowSerialServlet(Serial serial) {
        this.serial = serial;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("serial", serial);
        req.getRequestDispatcher("showSerial.jsp").forward(req, resp);
    }
}
