package by.ysenko.finaltask.controller.commands;

import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.CurrencyService;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCurrency extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Currency currency=new Currency();
        currency.setName((String)request.getParameter("currency"));
        CurrencyService service = ServiceFactory.createCurrencyService();
        try {
            service.add(currency);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return "/currencies.html";
    }
}
