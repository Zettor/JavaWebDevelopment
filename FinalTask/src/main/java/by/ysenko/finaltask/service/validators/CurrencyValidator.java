package by.ysenko.finaltask.service.validators;

import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

public class CurrencyValidator {

    public Currency validate(Currency currency) throws IncorrectFormDataException {

        String parameter = currency.getName();
        if (parameter.length() <= 3 && parameter.matches("[A-Z]+")) {
            currency.setName(parameter);
        } else {
            throw new IncorrectFormDataException("currency");
        }

        return currency;
    }
}
