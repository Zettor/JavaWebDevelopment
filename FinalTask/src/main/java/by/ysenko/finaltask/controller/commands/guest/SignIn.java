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

    private final static String LOGIN_ATTRIBUTE = "login";
    private final static String PASSWORD_ATTRIBUTE = "password";
    private final static String USER_ATTRIBUTE = "user";
    private final static String ERROR_ATTRIBUTE = "error";
    private final static int ERROR_TYPE = 0;
    private final static String MESSAGE_ATTRIBUTE = "message";
    private final static String TO_HTML = "/.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService service = ServiceFactory.createUserService();
        HttpSession session = request.getSession(false);
        try {
            String login = request.getParameter(LOGIN_ATTRIBUTE);
            String password = request.getParameter(PASSWORD_ATTRIBUTE);


            User user = service.signIn(login, password);
            session.setAttribute(USER_ATTRIBUTE, user);

        } catch (IncorrectFormDataException  | DataNotException | BlockException e) {
            session.setAttribute(ERROR_ATTRIBUTE, ERROR_TYPE);
            session.setAttribute(MESSAGE_ATTRIBUTE, e.getMessage());


        }       return TO_HTML;
    }
}

