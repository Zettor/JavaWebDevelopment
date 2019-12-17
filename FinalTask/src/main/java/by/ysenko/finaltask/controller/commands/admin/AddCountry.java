package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.Country;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.CountryService;
import by.ysenko.finaltask.service.factories.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCountry extends AdminCommand {

    private final static String COUNTRY_ATTRIBUTE = "country";
    private final static String TO_HTML = "/countries.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Country country = new Country();
        country.setName((String) request.getParameter(COUNTRY_ATTRIBUTE));
        CountryService service = ServiceFactory.createCountryService();
        service.add(country);
        return TO_HTML;
    }
}
