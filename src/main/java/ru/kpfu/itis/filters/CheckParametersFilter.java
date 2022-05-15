package ru.kpfu.itis.filters;


import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.helper.CheckParametersHelper;

@Component
public class CheckParametersFilter implements Filter {

    private final RequestMatcher signupRequest = new AntPathRequestMatcher("/signup", "POST");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (signupRequest.matches(req)) {

            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            if (!CheckParametersHelper.checkName(name)) {
                servletRequest.setAttribute("error", "Name format is incorrect");
                resp.sendRedirect("signup");
            }
            else if (!CheckParametersHelper.checkEmail(email)) {
                servletRequest.setAttribute("error", "Email format is incorrect");
                resp.sendRedirect("signup");
            }
            else if (!CheckParametersHelper.checkPassword(password)) {
                servletRequest.setAttribute("error", "Password format is incorrect");
                resp.sendRedirect("signup");
            }
            else {
                filterChain.doFilter(req, resp);
            }
        }
        else {
            filterChain.doFilter(req, resp);
        }
    }
}
