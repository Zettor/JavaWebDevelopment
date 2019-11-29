package by.ysenko.finaltask.controller.commands;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

public class SignIn implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService service = ServiceFactory.createUserService();


        String login = request.getParameter("login");
        String password= request.getParameter("password");
        try {
            User user = service.signIn(login,password);
            HttpSession session = request.getSession(false);
            session.setAttribute("user", user);
        } catch (PersistentException e) {
            System.out.println(e.getMessage());
        }
        return "/.html";
    }
}

