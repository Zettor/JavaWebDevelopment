package by.ysenko.finaltask.controller.filters;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.controller.commands.Command;
import by.ysenko.finaltask.controller.commands.CommandManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class SecurityFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            Command command = (Command) httpRequest.getAttribute("action");
            List<Integer> roles = command.getRoles();
            HttpSession session = httpRequest.getSession(false);
            User user = null;
            boolean canExecute = false;

            if (session != null) {
                user = (User) session.getAttribute("user");
                if (user == null) {
                    canExecute = roles.contains(null);
                } else {
                    canExecute = roles.contains(user.getRole());
                }
            } else {
                canExecute = roles.contains(null);
            }
            if (canExecute) {

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result");
                requestDispatcher.forward(request, response);
            } else {
                if (session != null) {
                    session.setAttribute("SecurityFilterMessage", "Доступ запрещён");
                }
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/.html");
            }
        } else {
            request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }

    }

    @Override
    public void destroy() {
    }
}
