package by.ysenko.finaltask.controller.commands.guest;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.controller.commands.GuestCommand;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.factories.ServiceFactory;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class  FindAllUsers extends GuestCommand {

    private final static String LIST_ATTRIBUTE = "list";
    private final static String TO_JSP = "/users.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService service = ServiceFactory.createUserService();
        List<User> users = null;
            users = service.findAll();
        request.setAttribute(LIST_ATTRIBUTE, users);
        return TO_JSP;
    }
}
