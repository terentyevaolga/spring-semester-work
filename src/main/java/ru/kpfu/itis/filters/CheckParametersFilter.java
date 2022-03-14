package ru.kpfu.itis.filters;


import ru.kpfu.itis.helper.CheckParametersHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/signup")
public class CheckParametersFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
//        String phone = req.getParameter("phone");
//        String comment = req.getParameter("comment");

        if(!CheckParametersHelper.checkName(name)){
            servletRequest.setAttribute("error", "Name format is incorrect");
            resp.sendRedirect("signup.jsp");
        }
        else if (!CheckParametersHelper.checkEmail(email)){
            servletRequest.setAttribute("error", "Email format is incorrect");
            resp.sendRedirect("signup.jsp");
        }
        else if(!CheckParametersHelper.checkPassword(password)){
            servletRequest.setAttribute("error", "Password format is incorrect");
            resp.sendRedirect("signup.jsp");
        }
//        else if(!CheckParametersHelper.checkPhone(phone)) {
//            servletRequest.setAttribute("error", "Phone format is incorrect");
//            resp.sendRedirect("review.jsp");
//        }
//        else if (!CheckParametersHelper.checkComment(comment)) {
//            servletRequest.setAttribute("error", "Comment format is incorrect");
//            resp.sendRedirect("review.jsp");
//        }
        else{
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
