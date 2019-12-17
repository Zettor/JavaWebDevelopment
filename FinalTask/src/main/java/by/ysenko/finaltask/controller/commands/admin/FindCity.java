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

    private final static String ID_ATTRIBUTE = "id";
    private final static String COUNTRY_ID_ATTRIBUTE = "countryId";
    private final static String LIST_ATTRIBUTE = "list";
    private final static String TO_JSP = "/cities.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer countryId=null;
        HttpSession session =request.getSession(false);
        if(session.getAttribute(ID_ATTRIBUTE)!=null){
            countryId=Integer.parseInt((String)session.getAttribute(ID_ATTRIBUTE));
        }else{
            countryId=Integer.parseInt(request.getParameter(ID_ATTRIBUTE));
        }
        CityService service = ServiceFactory.createCityService();
        List<City> cities = null;
            cities = service.findByCountryId(countryId);
        request.setAttribute(LIST_ATTRIBUTE,cities);
        request.setAttribute(COUNTRY_ID_ATTRIBUTE,countryId);
        return TO_JSP;
    }
}
