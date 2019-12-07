package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.CurrencyService;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindCurrencies extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CurrencyService service = ServiceFactory.createCurrencyService();
        List<Currency> currencies = null;
        try {
            currencies = service.findAll();
        } catch (PersistentException e) {
            //log
        }
        request.setAttribute("currencies",currencies);
        return "/currencies.jsp";
    }
}
