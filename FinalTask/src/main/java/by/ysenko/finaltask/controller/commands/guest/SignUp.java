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

    private final static String LOGIN_ATTRIBUTE = "login";
    private final static String PASSWORD_ATTRIBUTE = "password";
    private final static String EMAIL_ATTRIBUTE = "email";
    private final static String USER_ATTRIBUTE = "user";
    private final static String ERROR_ATTRIBUTE = "error";
    private final static int ERROR_TYPE = 1;
    private final static String MESSAGE_ATTRIBUTE = "message";
    private final static String TO_HTML = "/.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        UserService service = ServiceFactory.createUserService();
        User user = null;
        HttpSession session = request.getSession(false);
        try {
            user = checkUser(request);
            service.signUp(user);
            session.setAttribute(USER_ATTRIBUTE, user);
        } catch (IncorrectFormDataException | DataExistsException e) {
            session.setAttribute(ERROR_ATTRIBUTE, ERROR_TYPE);
            session.setAttribute(MESSAGE_ATTRIBUTE, e.getMessage());
        }
        return TO_HTML;
    }

    public User checkUser(HttpServletRequest request) throws IncorrectFormDataException {
        User user = new User();


        String parameter = request.getParameter(LOGIN_ATTRIBUTE);
        if (parameter != null && !parameter.isEmpty()) {
            user.setLogin(parameter);
        } else {
            throw new IncorrectFormDataException(LOGIN_ATTRIBUTE);
        }

        parameter = request.getParameter(PASSWORD_ATTRIBUTE);
        if (parameter != null && !parameter.isEmpty()) {
            user.setPassword(parameter);
        } else {
            throw new IncorrectFormDataException(PASSWORD_ATTRIBUTE);
        }

        parameter = request.getParameter(EMAIL_ATTRIBUTE);
        if (parameter != null && !parameter.isEmpty()) {
            user.setEmail(parameter);
        } else {
            throw new IncorrectFormDataException(EMAIL_ATTRIBUTE);
        }
        user.setCreateDate(new Timestamp(new Date().getTime()));
        user.setRole(0);
        user.setStatus(0);

        return user;
    }
}
