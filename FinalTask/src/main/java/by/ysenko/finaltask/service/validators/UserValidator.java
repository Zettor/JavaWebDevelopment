package by.ysenko.finaltask.service.validators;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

public class UserValidator {

    public void validate(User user) throws IncorrectFormDataException {


        Integer intParameter = user.getId();
        if (intParameter != null)
            if (intParameter < 0) {
                throw new IncorrectFormDataException("id");
            }

        String parameter = user.getLogin();
        if (parameter.length() > 16 || !parameter.matches("[A-Za-z0-9]+")) {

            throw new IncorrectFormDataException("login");
        }

        parameter = user.getPassword();
        if (parameter.length() < 4 || parameter.length() > 10 || !parameter.matches("[A-Za-z0-9]+")) {

            throw new IncorrectFormDataException("password");
        }

        parameter = user.getEmail();
        if (parameter.length() > 255 || !parameter.matches("\\w+@[a-zA-Z]+?\\.[a-zA-Z]{2,6}")) {
            throw new IncorrectFormDataException("email");
        }

        parameter = user.getPhone();
        if (parameter != null)
            if (parameter.length() > 13 || parameter.length() < 7 || !parameter.matches("^[-._a-z0-9]+@(?:[a-z0-9][-a-z0-9]+\\.)+[a-z]{2,6}$")) {
                user.setPhone(parameter);
            } else {
                throw new IncorrectFormDataException("phone");
            }

        parameter = user.getPhone();
        if (parameter != null)
            if (parameter.length() > 13 || parameter.length() < 7 || !parameter.matches("/^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$/")) {
                throw new IncorrectFormDataException("phone");
            }

        if (user.getCountry() != null) {
            intParameter = user.getCountry().getId();
            if (intParameter != null)
                if (intParameter < 0) {
                    throw new IncorrectFormDataException("country");
                }
            if (user.getCity() != null) {
                intParameter = user.getCity().getId();
                if (intParameter != null)
                    if (intParameter < 0) {
                        throw new IncorrectFormDataException("city");
                    }
            }
        }
        intParameter = user.getRole();
        if (intParameter != null)
            if (intParameter < 0 || intParameter > 1) {
                throw new IncorrectFormDataException("role");
            }

        intParameter = user.getStatus();
        if (intParameter != null)
            if (intParameter < 0 || intParameter > 1) {
                throw new IncorrectFormDataException("status");
            }
    }
}


