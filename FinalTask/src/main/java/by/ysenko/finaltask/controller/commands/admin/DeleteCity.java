package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.CityService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteCity extends AdminCommand {

    private final static String COUNTRY_ID_ATTRIBUTE = "countryId";
    private final static String ID_ATTRIBUTE = "id";
    private final static String TO_HTML = "/cities.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session=request.getSession(false);

        session.setAttribute(ID_ATTRIBUTE,request.getParameter(COUNTRY_ID_ATTRIBUTE));
            Integer id = Integer.parseInt((String) request.getParameter(ID_ATTRIBUTE));
            CityService service = ServiceFactory.createCityService();
                service.delete(id);
            return TO_HTML;

    }
}
