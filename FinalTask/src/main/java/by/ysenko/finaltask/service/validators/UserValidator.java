package by.ysenko.finaltask.service.validators;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

public class UserValidator {

    public User validate(HttpServletRequest request) throws IncorrectFormDataException {
        User user = new User();

        String parameter = request.getParameter("login");
        if (parameter != null && !parameter.isEmpty() && parameter.length() <= 16 && parameter.matches("[A-Za-z0-9-]+")) {
            user.setLogin(parameter);
        } else {
            throw new IncorrectFormDataException("login");
        }

        parameter = request.getParameter("password");
        if (parameter != null && !parameter.isEmpty() && parameter.length() >= 4 && parameter.length() <= 10 && parameter.matches("[A-Za-z0-9-]+")) {
            user.setPassword(parameter);
        } else {
            throw new IncorrectFormDataException("password");
        }

        parameter = request.getParameter("email");
        if (parameter != null && !parameter.isEmpty() && parameter.length() <= 255 && parameter.matches("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}")) {
            user.setEmail(parameter);
        } else {
            throw new IncorrectFormDataException("email");
        }

        parameter = request.getParameter("country");
        if (parameter != null) {
            if (!parameter.isEmpty() && parameter.matches("[A-Za-z]+")) {
                user.setCountry(parameter);
            } else {
                throw new IncorrectFormDataException("country");
            }
        }
        parameter = request.getParameter("state");
        if (parameter != null) {
            if (!parameter.isEmpty() && parameter.matches("[A-Za-z]+")) {
                user.setState(parameter);
            } else {
                throw new IncorrectFormDataException("state");
            }
        }
        parameter = request.getParameter("city");
        if (parameter != null) {
            if (!parameter.isEmpty() && parameter.matches("[A-Za-z]+")) {
                user.setCity(parameter);
            } else {
                throw new IncorrectFormDataException("city");
            }
        }
            parameter = request.getParameter("phone");
            if (parameter != null)
                if (!parameter.isEmpty() && parameter.length() <= 13 && parameter.length() >= 7 && parameter.matches("/^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$/")) {
                    user.setLogin(parameter);
                } else {
                    throw new IncorrectFormDataException("phone");
                }
        user.setCreateDate(new Timestamp(new Date().getTime()));
        user.setRole(0);
        user.setStatus(0);
        return user;
    }
}


