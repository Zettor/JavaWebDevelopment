package by.ysenko.finaltask.controller.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieLocaleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getParameter("locale") != null) {
            Cookie cookie = new Cookie("locale", req.getParameter("locale"));
            cookie.setMaxAge(30 * 60 * 60);
            res.addCookie(cookie);
            req.setAttribute("locale", req.getParameter("locale"));
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
