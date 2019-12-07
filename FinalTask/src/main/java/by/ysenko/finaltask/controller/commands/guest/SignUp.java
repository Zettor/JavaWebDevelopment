package by.ysenko.finaltask.controller.commands.guest;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.controller.commands.GuestCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.exceptions.DataExistsException;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;
import by.ysenko.finaltask.service.factories.ServiceFactory;
import by.ysenko.finaltask.service.validators.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class SignUp extends GuestCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService service = ServiceFactory.createUserService();
        User user = null;
        UserValidator validator = new UserValidator();
        HttpSession session = request.getSession(false);
        try {
            user = validator.validate(request);
            try {
                service.signUp(user);
                session.setAttribute("user", user);
            } catch (PersistentException e) {
                System.out.println(e.getMessage());
            }
        } catch (IncorrectFormDataException | DataExistsException e) {
            session.setAttribute("error", 1);
            session.setAttribute("message", e.getMessage());
        }
        return "/.html";
    }
}
