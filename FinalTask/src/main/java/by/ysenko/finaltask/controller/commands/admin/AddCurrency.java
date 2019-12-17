package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.CurrencyService;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;
import by.ysenko.finaltask.service.factories.ServiceFactory;
import by.ysenko.finaltask.service.validators.CurrencyValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCurrency extends AdminCommand {

    private final static String ERROR_ATTRIBUTE = "error";
    private final static String MESSAGE_ATTRIBUTE = "message";
    private final static String TO_HTML = "/currencies.html";
    private final static int ERROR_TYPE = 2;


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
            session.setAttribute(ERROR_ATTRIBUTE, ERROR_TYPE);
            session.setAttribute(MESSAGE_ATTRIBUTE, e.getMessage());
        }
        return TO_HTML;
    }
}
