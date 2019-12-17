package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.Country;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.CountryService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindCountries extends AdminCommand {

    private final static String LIST_ATTRIBUTE = "list";
    private final static String TO_JSP = "/countries.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CountryService service = ServiceFactory.createCountryService();
        List<Country> countries = null;
            countries = service.findAll();
        request.setAttribute(LIST_ATTRIBUTE,countries);
        return TO_JSP;
    }
}
