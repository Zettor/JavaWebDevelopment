package by.ysenko.finaltask.controller.commands.guest;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.controller.commands.GuestCommand;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.exceptions.DataExistsException;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;
import by.ysenko.finaltask.service.factories.ServiceFactory;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

public class SignUp extends GuestCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        UserService service = ServiceFactory.createUserService();
        User user = null;
        HttpSession session = request.getSession(false);
        try {
            user = checkUser(request);
            service.signUp(user);
            session.setAttribute("user", user);
        } catch (IncorrectFormDataException | DataExistsException e) {
            session.setAttribute("error", 1);
            session.setAttribute("message", e.getMessage());
        }
        return "/.html";
    }

    public User checkUser(HttpServletRequest request) throws IncorrectFormDataException {
        User user = new User();


        String parameter = request.getParameter("login");
        if (parameter != null && !parameter.isEmpty()) {
            user.setLogin(parameter);
        } else {
            throw new IncorrectFormDataException("login");
        }

        parameter = request.getParameter("password");
        if (parameter != null && !parameter.isEmpty()) {
            user.setPassword(parameter);
        } else {
            throw new IncorrectFormDataException("password");
        }

        parameter = request.getParameter("email");
        if (parameter != null && !parameter.isEmpty()) {
            user.setEmail(parameter);
        } else {
            throw new IncorrectFormDataException("email");
        }
        user.setCreateDate(new Timestamp(new Date().getTime()));
        user.setRole(0);
        user.setStatus(0);

        return user;
    }
}
