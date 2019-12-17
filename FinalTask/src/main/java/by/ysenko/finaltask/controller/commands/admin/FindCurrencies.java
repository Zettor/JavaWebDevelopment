package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.CurrencyService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindCurrencies extends AdminCommand {

    private final static String CURRENCIES_ATTRIBUTE = "currencies";
    private final static String TO_JSP = "/currencies.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CurrencyService service = ServiceFactory.createCurrencyService();
        List<Currency> currencies = null;
            currencies = service.findAll();
        request.setAttribute(CURRENCIES_ATTRIBUTE,currencies);
        return TO_JSP;
    }
}
