package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.Country;
import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.CountryService;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;
import by.ysenko.finaltask.service.factories.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCountry extends AdminCommand {

    private final static String COUNTRY_ATTRIBUTE = "country";
    private final static String TO_HTML = "/countries.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CountryService service = ServiceFactory.createCountryService();
        Country country = null;
        HttpSession session=request.getSession(false);
        try {
            country = checkData(request);
            service.add(country);
        } catch (IncorrectFormDataException e) {
            session.setAttribute("error", 2);
            session.setAttribute("message", e.getMessage());
        }
        return TO_HTML;
    }

    private Country checkData(HttpServletRequest request) throws IncorrectFormDataException {
        Country country=new Country();
        String     parameter = request.getParameter("country");
        if (parameter != null && !parameter.isEmpty()) {
            country.setName(parameter);
        } else {
            throw new IncorrectFormDataException("country");
        }
        return country;
    }
}
