package by.ysenko.finaltask.controller.commands.guest;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.controller.commands.GuestCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.exceptions.BlockException;
import by.ysenko.finaltask.service.exceptions.DataExistsException;
import by.ysenko.finaltask.service.exceptions.DataNotException;
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

        } catch (IncorrectFormDataException  | DataNotException | BlockException e) {
            session.setAttribute("error", 0);
            session.setAttribute("message", e.getMessage());


        }       return "/.html";
    }
}

