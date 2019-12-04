package by.ysenko.finaltask.controller.commands;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.exceptions.DataExistsException;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

public class SignIn extends GuestCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService service = ServiceFactory.createUserService();
        HttpSession session = request.getSession(false);
        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");


            User user = service.signIn(login, password);
            session.setAttribute("user", user);

        } catch (IncorrectFormDataException | DataExistsException e) {
            session.setAttribute("error", 1);
            session.setAttribute("message", e.getMessage());
        } catch (PersistentException e) {
            System.out.println(e.getMessage());
        }
        return "/.html";
    }
}

