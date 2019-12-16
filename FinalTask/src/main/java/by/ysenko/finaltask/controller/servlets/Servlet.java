package by.ysenko.finaltask.controller.servlets;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.controller.commands.Command;
import by.ysenko.finaltask.controller.commands.CommandManager;
import by.ysenko.finaltask.dao.connection.ConnectionPool;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.factories.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@MultipartConfig
public class Servlet extends HttpServlet {


    @Override
    public void init() throws ServletException {

        ServiceFactory.createConnectionService().init();

    }

    protected void process(final HttpServletRequest request,
                           final HttpServletResponse response) throws IOException, ServletException {
        Command cm = (Command) request.getAttribute("action");
        String temp = cm.execute(request, response);
        if (temp.substring(temp.length() - 3).equals("jsp")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/" + temp);
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect(temp);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        ServiceFactory.createConnectionService().close();
    }
}
