package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.CurrencyService;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;
import by.ysenko.finaltask.service.factories.ServiceFactory;
import by.ysenko.finaltask.service.validators.CurrencyValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCurrency extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Currency currency = new Currency();
        CurrencyValidator validator = new CurrencyValidator();
        CurrencyService service = ServiceFactory.createCurrencyService();
        HttpSession session = request.getSession(false);
        try {
            currency = validator.validate(request);

            service.add(currency);
        } catch (IncorrectFormDataException e) {
            session.setAttribute("error", 2);
            session.setAttribute("message", e.getMessage());
        }
        return "/currencies.html";
    }
}
