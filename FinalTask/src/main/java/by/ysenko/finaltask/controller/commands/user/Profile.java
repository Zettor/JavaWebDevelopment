package by.ysenko.finaltask.controller.commands.user;

import by.ysenko.finaltask.bean.City;
import by.ysenko.finaltask.bean.Country;
import by.ysenko.finaltask.controller.commands.UserCommand;
import by.ysenko.finaltask.service.CityService;
import by.ysenko.finaltask.service.CountryService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class Profile extends UserCommand {

    private final static String COUNTRIES_ATTRIBUTE = "countries";
    private final static String CITIES_ATTRIBUTE = "cities";
    private final static String COUNTRY_ID_ATTRIBUTE = "country_id";
    private final static String TO_JSP = "/edit_profile.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession(false);
        CountryService service = ServiceFactory.createCountryService();
        List<Country> countries = null;

            countries = service.findAll();

        request.setAttribute(COUNTRIES_ATTRIBUTE,countries);
        if(session.getAttribute(COUNTRY_ID_ATTRIBUTE)!=null) {

            CityService cityService = ServiceFactory.createCityService();
            List<City> cities = null;
                cities = cityService.findByCountryId(Integer.parseInt((String) session.getAttribute("country_id")));
            request.setAttribute(CITIES_ATTRIBUTE, cities);
        }

        return TO_JSP;
    }
}
