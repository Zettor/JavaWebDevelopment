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
import java.util.List;

public class FindCity extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer countryId=null;
        HttpSession session =request.getSession(false);
        if(session.getAttribute("id")!=null){
            countryId=Integer.parseInt((String)session.getAttribute("id"));
        }else{
            countryId=Integer.parseInt(request.getParameter("id"));
        }
        CityService service = ServiceFactory.createCityService();
        List<City> cities = null;
            cities = service.findByCountryId(countryId);
        request.setAttribute("list",cities);
        request.setAttribute("countryId",countryId);
        return "/cities.jsp";
    }
}
