package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.factories.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SetUserStatus extends AdminCommand {

    private final static String ID_ATTRIBUTE = "id";
    private final static String STATUS_ATTRIBUTE = "status";
    private final static String TO_HTML = "/users.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService service = ServiceFactory.createUserService();


        Integer id = Integer.parseInt(request.getParameter(ID_ATTRIBUTE));
        Integer status = Integer.parseInt(request.getParameter(STATUS_ATTRIBUTE));

            service.setStatus(id, status);

        return TO_HTML;

    }
}