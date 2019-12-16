package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.Country;
import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.CountryService;
import by.ysenko.finaltask.service.CurrencyService;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;
import by.ysenko.finaltask.service.factories.ServiceFactory;
import by.ysenko.finaltask.service.validators.CurrencyValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCountry extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
       Country country=new Country();
        country.setName((String)request.getParameter("country"));
        CountryService service = ServiceFactory.createCountryService();
            service.add(country);
        return "/countries.html";
    }
}
