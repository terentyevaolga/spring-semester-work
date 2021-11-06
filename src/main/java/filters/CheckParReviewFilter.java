package filters;

import helper.CheckParametersHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/sendReview")
public class CheckParReviewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("UTF-8");

        String phone = req.getParameter("phone");
        String comment = req.getParameter("comment");

        if(!CheckParametersHelper.checkPhone(phone)) {
            servletRequest.setAttribute("error", "Phone format is incorrect");
            resp.sendRedirect("review.jsp");
        }
        else if (!CheckParametersHelper.checkComment(comment)) {
            servletRequest.setAttribute("error", "Comment format is incorrect");
            resp.sendRedirect("review.jsp");
        }
        else{
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
