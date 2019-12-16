package by.ysenko.finaltask.controller.filters;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.ysenko.finaltask.controller.commands.CommandManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionFilter implements Filter {
    private static Logger logger = LogManager.getLogger(ActionFilter.class);
    private FilterConfig filterConfig;
    static int i=0;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            String contextPath = httpRequest.getContextPath();
            String uri = httpRequest.getRequestURI();
            int beginAction = contextPath.length();
            int endAction = uri.lastIndexOf('.');
            String actionName;

            if (endAction >= 0) {
                actionName = uri.substring(beginAction, endAction);

            } else {
                actionName = uri.substring(beginAction);
            }
            CommandManager commandManager = new CommandManager(actionName);

            httpRequest.setAttribute("action", commandManager.getCommand());
            HttpSession session = httpRequest.getSession(false);
            if(session!=null && session.getAttribute("error")!=null){
                request.setAttribute("error",session.getAttribute("error"));
                session.removeAttribute("error");
                request.setAttribute("message",session.getAttribute("message"));
                session.removeAttribute("message");
            }

            chain.doFilter(request, response);

        }
    }
    @Override
    public void destroy() {}
}
