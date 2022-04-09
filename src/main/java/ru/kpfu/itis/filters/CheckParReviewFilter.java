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
public class CheckParReviewFilter implements Filter {

    private final RequestMatcher reviewRequest = new AntPathRequestMatcher("/sendReview", "POST");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("UTF-8");
        if (reviewRequest.matches(req)) {
            String phone = req.getParameter("phone");
            String comment = req.getParameter("comment");

            if (!CheckParametersHelper.checkPhone(phone)) {
                servletRequest.setAttribute("error", "Phone format is incorrect");
                resp.sendRedirect("review.ftl");
            }
            else if (!CheckParametersHelper.checkComment(comment)) {
                servletRequest.setAttribute("error", "Comment format is incorrect");
                resp.sendRedirect("review.ftl");
            }
            else {
                filterChain.doFilter(req, resp);
            }
        } else {
            filterChain.doFilter(req, resp);
        }
    }
}
