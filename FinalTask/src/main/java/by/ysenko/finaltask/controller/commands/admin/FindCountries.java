package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.Country;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.controller.commands.GuestCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.CountryService;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindCountries extends AdminCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CountryService service = ServiceFactory.createCountryService();
        List<Country> countries = null;
            countries = service.findAll();
        request.setAttribute("list",countries);
        return "/countries.jsp";
    }
}