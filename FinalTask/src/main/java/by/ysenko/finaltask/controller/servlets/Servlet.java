package by.ysenko.finaltask.controller.servlets;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.controller.commands.Command;
import by.ysenko.finaltask.controller.commands.CommandManager;
import by.ysenko.finaltask.dao.connection.ConnectionPool;
import by.ysenko.finaltask.dao.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class Servlet extends HttpServlet {


    public static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/ps4_shop?useUnicode=true&characterEncoding=UTF-8&useLegacyDatetimeCode=false&serverTimezone=Europe/Minsk";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "sayan2013";
    public static final int DB_POOL_START_SIZE = 10;
    public static final int DB_POOL_MAX_SIZE = 1000;
    public static final int DB_POOL_CHECK_CONNECTION_TIMEOUT = 0;

    @Override
    public void init() {
        try {
            ConnectionPool.getInstance().init(DB_DRIVER_CLASS, DB_URL, DB_USER, DB_PASSWORD, DB_POOL_START_SIZE, DB_POOL_MAX_SIZE, DB_POOL_CHECK_CONNECTION_TIMEOUT);
        } catch (PersistentException e) {
            destroy();
        }
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Command cm = (Command) request.getAttribute("action");
        String temp = cm.execute(request, response);
        if (temp.substring(temp.length() - 3).equals("jsp")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(temp);
            requestDispatcher.forward(request, response);
        } else
            response.sendRedirect(temp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }


}
