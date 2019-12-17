package by.ysenko.finaltask.controller.commands.guest;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.controller.commands.GuestCommand;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToProfile extends GuestCommand {


    private final static String ID_ATTRIBUTE = "id";
    private final static String USER_ATTRIBUTE = "user";
    private final static String TO_JSP = "/profile.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer id = null;

        if (request.getParameter(ID_ATTRIBUTE) != null && !request.getParameter(ID_ATTRIBUTE).isEmpty()) {
            id = Integer.parseInt(request.getParameter(ID_ATTRIBUTE));
        } else {
            HttpSession session = request.getSession(false);
            id = ((User) session.getAttribute(USER_ATTRIBUTE)).getId();

        }
        UserService service = ServiceFactory.createUserService();

        User user = service.findById(id);
        request.setAttribute(USER_ATTRIBUTE, user);

        return TO_JSP;
    }
}
