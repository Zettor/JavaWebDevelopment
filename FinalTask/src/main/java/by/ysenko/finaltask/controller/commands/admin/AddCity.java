package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.City;
import by.ysenko.finaltask.bean.Country;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.CityService;
import by.ysenko.finaltask.service.CountryService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCity extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession(false);

        City city = new City();
        city.setName(request.getParameter("city"));
        city.setCountryId(Integer.parseInt(request.getParameter("id")));
        session.setAttribute("id",request.getParameter("id"));
        CityService service = ServiceFactory.createCityService();
            service.add(city);
        return "/cities.html";
    }
}
